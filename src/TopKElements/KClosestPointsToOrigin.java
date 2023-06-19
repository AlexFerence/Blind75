package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  private static class Storage {
    public double distToOrigin;
    public Point p;
    public Storage(double d, Point p) {
      this.distToOrigin = d;
      this.p = p;
    }
  }

  // This problem is a very useful one to know how to solve
  // Application - uber
  public static List<Point> kClosest(Point[] points, int k) {

    // Check to see if this is the right implementation
    PriorityQueue<Storage> maxHeap = new PriorityQueue<Storage>((a, b) -> Double.compare(b.distToOrigin, a.distToOrigin));

    for (Point p : points) {
      Storage newPoint = new Storage(distanceToOrigin(p), p);
      if (maxHeap.size() < k) {
        maxHeap.add(newPoint);
      }
      else if (maxHeap.size() > 0 && newPoint.distToOrigin < maxHeap.peek().distToOrigin) {
        maxHeap.poll();
        maxHeap.add(newPoint);
      }
    }

    List<Point> res = new ArrayList<>();

    while (maxHeap.size() > 0) {
      res.add(maxHeap.poll().p);
    }

    // Your code will replace this placeholder return statement
    return res;
  }

  public static double distanceToOrigin(Point p) {
    return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
  }


}
