

package com.iluwatar.spatialpartition;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class extends the generic SpatialPartition abstract class and is used in
 * our example to keep track of all the bubbles that collide, pop and stay un-popped.
 */

public class SpatialPartitionBubbles extends SpatialPartitionGeneric<Bubble> {

  Hashtable<Integer, Bubble> bubbles;
  QuadTree qTree;

  SpatialPartitionBubbles(Hashtable<Integer, Bubble> bubbles, QuadTree qTree) {
    this.bubbles = bubbles;
    this.qTree = qTree;
  }

  void handleCollisionsUsingQt(Bubble b) {
    //finding points within area of a square drawn with centre same as centre of bubble and length = radius of bubble
    Rect rect = new Rect(b.x, b.y, 2 * b.radius, 2 * b.radius);
    ArrayList<Point> quadTreeQueryResult = new ArrayList<Point>();
    this.qTree.query(rect, quadTreeQueryResult);
    //handling these collisions
    b.handleCollision(quadTreeQueryResult, this.bubbles);
  }
}
