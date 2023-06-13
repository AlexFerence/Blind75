package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianOfAStream {

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianOfAStream() {
    // Write your code here
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void insertNum(int num) {

    if (num > maxHeap.size()) {
      minHeap.add(num);
      // Rebalance the heaps if they are unbalanced
      if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
    }
    else {
      maxHeap.add(num);
      // Rebalance
      if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
    }
    return;
  }

  public double findMedian() {
    if (maxHeap.size() > 0 && minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    }
    else {
      return maxHeap.peek();
    }
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(22);
    medianOfAStream.insertNum(35);
    medianOfAStream.insertNum(36);
    System.out.println(medianOfAStream.findMedian());
    medianOfAStream.insertNum(27);

  }
}
