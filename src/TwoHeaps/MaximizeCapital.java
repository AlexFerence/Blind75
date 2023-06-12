package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {

  // Need to follow the problem step by step

  public static int maximumCapital(int c, int k, int[] capitals,int[] profits) {

    PriorityQueue<Integer> capitalMinHeap = new PriorityQueue<>();

    Comparator<Integer> maxHeapComparator = Comparator.reverseOrder();
    PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(maxHeapComparator);

    // Populate min heap
    for (int i = 0; i < capitals.length; i++) {
      if (capitals[i] <= c) {
        profitMaxHeap.add(profits[i]);
      }
    }





    return -1;
  }

  public static void main(String[] args) {
    int[] capitals = {1,2,2,3};
    int[] profits = {2,4,6,8};
    int c = 1;
    int k = 2;

    int res = maximumCapital(c,k,capitals,profits);

    System.out.println(res);

  }
}
