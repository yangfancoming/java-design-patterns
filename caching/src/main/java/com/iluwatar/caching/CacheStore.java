
package com.iluwatar.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 * The caching strategies are implemented in this class.
 *
 */
public class CacheStore {

  private static final Logger LOGGER = LoggerFactory.getLogger(CacheStore.class);

  static LruCache cache;

  private CacheStore() {
  }

  /**
   * Init cache capacity
   */
  public static void initCapacity(int capacity) {
    if (cache == null) {
      cache = new LruCache(capacity);
    } else {
      cache.setCapacity(capacity);
    }
  }

  /**
   * Get user account using read-through cache
   */
  public static UserAccount readThrough(String userId) {
    if (cache.contains(userId)) {
      LOGGER.info("# Cache Hit!");
      return cache.get(userId);
    }
    LOGGER.info("# Cache Miss!");
    UserAccount userAccount = DbManager.readFromDb(userId);
    cache.set(userId, userAccount);
    return userAccount;
  }

  /**
   * Get user account using write-through cache
   */
  public static void writeThrough(UserAccount userAccount) {
    if (cache.contains(userAccount.getUserId())) {
      DbManager.updateDb(userAccount);
    } else {
      DbManager.writeToDb(userAccount);
    }
    cache.set(userAccount.getUserId(), userAccount);
  }

  /**
   * Get user account using write-around cache
   */
  public static void writeAround(UserAccount userAccount) {
    if (cache.contains(userAccount.getUserId())) {
      DbManager.updateDb(userAccount);
      cache.invalidate(userAccount.getUserId()); // Cache data has been updated -- remove older
                                                 // version from cache.
    } else {
      DbManager.writeToDb(userAccount);
    }
  }

  /**
   * Get user account using read-through cache with write-back policy
   */
  public static UserAccount readThroughWithWriteBackPolicy(String userId) {
    if (cache.contains(userId)) {
      LOGGER.info("# Cache Hit!");
      return cache.get(userId);
    }
    LOGGER.info("# Cache Miss!");
    UserAccount userAccount = DbManager.readFromDb(userId);
    if (cache.isFull()) {
      LOGGER.info("# Cache is FULL! Writing LRU data to DB...");
      UserAccount toBeWrittenToDb = cache.getLruData();
      DbManager.upsertDb(toBeWrittenToDb);
    }
    cache.set(userId, userAccount);
    return userAccount;
  }

  /**
   * Set user account
   */
  public static void writeBehind(UserAccount userAccount) {
    if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
      LOGGER.info("# Cache is FULL! Writing LRU data to DB...");
      UserAccount toBeWrittenToDb = cache.getLruData();
      DbManager.upsertDb(toBeWrittenToDb);
    }
    cache.set(userAccount.getUserId(), userAccount);
  }

  /**
   * Clears cache
   */
  public static void clearCache() {
    if (cache != null) {
      cache.clear();
    }
  }

  /**
   * Writes remaining content in the cache into the DB.
   */
  public static void flushCache() {
    LOGGER.info("# flushCache...");
    if (null == cache) {
      return;
    }
    List<UserAccount> listOfUserAccounts = cache.getCacheDataInListForm();
    for (UserAccount userAccount : listOfUserAccounts) {
      DbManager.upsertDb(userAccount);
    }
  }

  /**
   * Print user accounts
   */
  public static String print() {
    List<UserAccount> listOfUserAccounts = cache.getCacheDataInListForm();
    StringBuilder sb = new StringBuilder();
    sb.append("\n--CACHE CONTENT--\n");
    for (UserAccount userAccount : listOfUserAccounts) {
      sb.append(userAccount.toString() + "\n");
    }
    sb.append("----\n");
    return sb.toString();
  }

  /**
   * Delegate to backing cache store
   */
  public static UserAccount get(String userId) {
    return cache.get(userId);
  }

  /**
   * Delegate to backing cache store
   */
  public static void set(String userId, UserAccount userAccount) {
    cache.set(userId, userAccount);
  }

  /**
   * Delegate to backing cache store
   */
  public static void invalidate(String userId) {
    cache.invalidate(userId);
  }
}
