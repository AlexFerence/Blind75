package TopKElements;

import java.util.PriorityQueue;

public class KthLargestEl {

  public static int findKthLargest(int[] arr, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      int element = arr[i];

      if (minHeap.size() < k) {
        minHeap.add(element);
      }
      else if (minHeap.size() > 0 && element > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(element);
      }
    }

    return minHeap.peek();
  }

}
