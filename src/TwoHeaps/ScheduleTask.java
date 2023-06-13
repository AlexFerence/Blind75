package TwoHeaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTask {

  public static int tasks(ArrayList<ArrayList<Integer>> tasksList) {

    PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));

    PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<>();

    minHeap.addAll(tasksList);

    int numTasks = 0;

    while (minHeap.size() > 0) {
      ArrayList<Integer> task = minHeap.poll();
      int taskStart = task.get(0);
      int taskEnd = task.get(1);

      // Clean the min heap
      while (endTimeMinHeap.size() > 0 && endTimeMinHeap.peek() <= taskStart) {
        endTimeMinHeap.poll();
      }
      // Add the end time to the
      endTimeMinHeap.add(taskEnd);

      numTasks = Math.max(numTasks, endTimeMinHeap.size());
    }

    return numTasks;
  }

  public static void main(String[] args) {
    int[][] array = {{1, 2}, {2,7}, {8, 13}};
    ArrayList<ArrayList<Integer>> nestedList = new ArrayList<>();
    for (int[] subArray : array) {
      ArrayList<Integer> sublist = new ArrayList<>();
      for (int num : subArray) {
        sublist.add(num);
      }
      nestedList.add(sublist);
    }

    System.out.println(tasks(nestedList));
  }
}
