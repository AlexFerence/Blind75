package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {

  public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
    // Your code will replace this placeholder return statement

    // Dont be stupid, add all of them to one single list and sort

    List<Interval> ans = new ArrayList<Interval>();
    return ans;
  }

  public static void main(String[] args) {
    // [1, 2], [5, 6]
    ArrayList<Interval> emp1 = new ArrayList<Interval>();
    emp1.add(new Interval(1, 2));
    emp1.add(new Interval(5, 6));

    // [1, 3]
    ArrayList<Interval> emp2 = new ArrayList<Interval>();
    emp2.add(new Interval(1, 3));

    // [4, 10]
    ArrayList<Interval> emp3 = new ArrayList<Interval>();
    emp3.add(new Interval(4, 10));

    ArrayList<ArrayList<Interval>> input = new ArrayList<ArrayList<Interval>>();
    input.add(emp1);
    input.add(emp2);
    input.add(emp3);

    List<Interval> result = employeeFreeTime(input);
    System.out.print("Free intervals: ");
    System.out.println(result);
  }


}
