package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

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

  public static List<Interval> insertInterval(List <Interval> existingIntervals, Interval newInterval) {
    boolean inserted = false;
    // Just add in proper spot then merge?
    for (int i = 0; i < existingIntervals.size(); i++) {
      // If the start of newInterval is less than or equal to currentInterval then insert before
      Interval current = existingIntervals.get(i);
      if (newInterval.start <= current.start) {
        // Inserts at index i, pushes all other intervals back
        existingIntervals.add(i, newInterval);
        inserted = true;
        break;
      }
    }
    // If it wasn't added, add it at the end
    if (!inserted) existingIntervals.add(newInterval);
    // Write your code here
    return mergeIntervals(existingIntervals);
  }

  public static void main(String[] args) {
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

    Interval newInterval = new Interval(2,10);
    List<Interval> res = mergeIntervals(insertInterval(intervals, newInterval));

    System.out.println(res);
  }
}
