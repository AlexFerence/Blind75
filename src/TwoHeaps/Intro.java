package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Intro {


  public static void main(String[] args) {

    // Min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Max heap
    Comparator<Integer> maxHeapComparator = Comparator.reverseOrder();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxHeapComparator);

    maxHeap.add(5);
    maxHeap.remove();

  }
}
