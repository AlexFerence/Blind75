package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {

  // Need to follow the problem step by step

  public static int maximumCapital(int c, int k, int[] capitals,int[] profits) {

    // Store capital and profit TOGETHER
    PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // Populate capitalMinHeap
    for (int x = 0; x < capitals.length; x++) capitalMinHeap.add(new int[]{capitals[x], profits[x]});

    for (int i = 0; i < k; i++) {
      // Pop all valid nodes in min heap
      while (capitalMinHeap.peek() != null && capitalMinHeap.peek()[0] <= c) {
        int profit = capitalMinHeap.poll()[1];
        profitMaxHeap.add(profit);
      }
      // Error handling
      if (profitMaxHeap.size() == 0) break;
      // Select the best profit from the max heap
      int maxProfit = profitMaxHeap.poll();
      c += maxProfit;
    }
    return c;
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
