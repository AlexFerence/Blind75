package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

  public static List<Interval> mergeIntervals(List<Interval> intervals) {
    List<Interval> finalIntervals = new ArrayList<>();
    Interval current = intervals.get(0);
    intervals.remove(0);

    for (Interval i : intervals) {
      if (current == null) current = i;
      else {
        if (i.start <= current.getEnd()) {
          // Merge
          current.setEnd(Math.max(current.getEnd(), i.getEnd()));
        }
        else {
          finalIntervals.add(current);
          current = i;
        }
      }
    }

    if (finalIntervals.size() == 0) {
      finalIntervals.add(current);
    }
    else {
      if (current != null && finalIntervals.get(finalIntervals.size() - 1).start != current.start) {
        finalIntervals.add(current);
      }
    }

    return finalIntervals;
  }

  public static void main(String[] args) {


    // [[1,3],[4,5],[7,8],[9,12],[13,14]]

    Interval i1 = new Interval(1,3);
    Interval i2 = new Interval(4,5);
    Interval i3 = new Interval(7,8);
    Interval i4 = new Interval(9,12);
    Interval i5 = new Interval(13,14);

    List<Interval> intervals = new ArrayList<>();
    intervals.add(i1);
    intervals.add(i2);
    intervals.add(i3);
    intervals.add(i4);
    intervals.add(i5);

    List<Interval> res = mergeIntervals(intervals);

    System.out.println(res);

  }
}
