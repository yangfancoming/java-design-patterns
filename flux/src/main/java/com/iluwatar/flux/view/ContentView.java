
package com.iluwatar.flux.view;

import com.iluwatar.flux.action.Content;
import com.iluwatar.flux.store.ContentStore;
import com.iluwatar.flux.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ContentView is a concrete view.
 *
 */
public class ContentView implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(ContentView.class);

  private Content content = Content.PRODUCTS;

  @Override
  public void storeChanged(Store store) {
    ContentStore contentStore = (ContentStore) store;
    content = contentStore.getContent();
    render();
  }

  @Override
  public void render() {
    LOGGER.info(content.toString());
  }
}
