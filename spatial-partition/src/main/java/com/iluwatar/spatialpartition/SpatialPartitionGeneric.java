

package com.iluwatar.spatialpartition;

import java.util.Hashtable;

/**
 * This abstract class has 2 fields, one of which is a hashtable containing all objects
 * that currently exist on the field and a quadtree which keeps track of locations.
 * @param <T> T will be type of object (that extends Point)
 */

public abstract class SpatialPartitionGeneric<T> {

  Hashtable<Integer, T> playerPositions;
  QuadTree qTree;

  /**
   * handles collisions for object obj using quadtree
   * @param obj is the object for which collisions need to be checked
   */
  abstract void handleCollisionsUsingQt(T obj);
}
