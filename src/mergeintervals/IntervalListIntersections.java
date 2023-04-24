package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

  public static List <Interval> intervalsIntersection(List <Interval> intervalLista, List <Interval> intervalListb) {
    List<Interval> intersections = new ArrayList<>();
    while (intervalLista.size() > 0 && intervalListb.size() > 0) {
      int maxStart = Math.max(intervalLista.get(0).start, intervalListb.get(0).start);
      int minEnd = Math.min(intervalLista.get(0).end, intervalListb.get(0).end);

      // Add an overlapping if nesecary
      if (maxStart <= minEnd) intersections.add(new Interval(maxStart, minEnd));

      // Handle going to the next element
      if (intervalLista.get(0).end == minEnd) intervalLista.remove(0);
      else intervalListb.remove(0);
    }
    return intersections;
  }

  public static void main(String[] args) {

    List<Interval> intervals1 = new ArrayList<>();
    // [1,4],[5,6],[7,8],[9,15]
    Interval i1 = new Interval(1,4);
    Interval i2 = new Interval(5,6);
    Interval i3 = new Interval(7,8);
    Interval i4 = new Interval(9,15);

    intervals1.add(i1);
    intervals1.add(i2);
    intervals1.add(i3);
    intervals1.add(i4);

    List<Interval> intervals2 = new ArrayList<>();
    // [2,4],[5,7],[9,15]
    Interval i5 = new Interval(2,4);
    Interval i6 = new Interval(5,7);
    Interval i7 = new Interval(9,15);

    intervals2.add(i5);
    intervals2.add(i6);
    intervals2.add(i7);

    Interval newInterval = new Interval(2,10);
    List<Interval> res = intervalsIntersection(intervals1, intervals2);
    System.out.println(res);
  }

}
