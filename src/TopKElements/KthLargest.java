package TopKElements;

import java.util.PriorityQueue;

class KthLargest {
  int k;
  int[] nums;
  PriorityQueue<Integer> minHeap;

  // constructor to initialize topKHeap and add values in it
  public KthLargest(int k, int[] nums) {
    // Write your code Here
    this.k = k;
    this.nums = nums;
    minHeap = new PriorityQueue<>();

    for (int n : nums) {
      add(n);
    }
  }

  // adds element in the topKHeap
  public int add(int val) {
    if (minHeap.size() < k) {
      minHeap.add(val);
    }
    else if (val > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(val);
    }
    return returnKthLargest();
  }

  // returns kth largest element from topKHeap
  public int returnKthLargest() {
    // Your code will replace this placeholder return statement
    return minHeap.peek();
  }

}
