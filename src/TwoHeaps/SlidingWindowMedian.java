package TwoHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

  public static double[] medianSlidingWindow(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // Push all elements into maxHeap
    int i = 0;
    while (i < k) {
      maxHeap.add(nums[i]);
      i++;
    }

    // Rebalance the heaps
    while (minHeap.size() < maxHeap.size() - 1) minHeap.add(maxHeap.poll());

    List<Double> medianStorage = new ArrayList<>();

    if (k == 1) {
      return Arrays.stream(nums).asDoubleStream().toArray();
    }

    while (i <= nums.length) {
      // Remove number that isn't
      if (i > k) {
        int indexToRemove = i - k - 1;
        int valueToRemove = nums[indexToRemove];

        if (minHeap.contains(valueToRemove)) {
          minHeap.remove(valueToRemove);
          if (minHeap.size() < maxHeap.size() - 1) {
            minHeap.add(maxHeap.poll());
          }
        }
        else if (maxHeap.contains(valueToRemove)) {
          maxHeap.remove(valueToRemove);
          // Rebalance the heaps
          if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
          }
        }
        // Add the new value
        int newValueToAdd = nums[i-1];
        if (newValueToAdd > maxHeap.peek()) {
          minHeap.add(newValueToAdd);
          if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
          }
        }
        else {
          maxHeap.add(newValueToAdd);
          if (minHeap.size() < maxHeap.size() - 1) {
            minHeap.add(maxHeap.poll());
          }
        }
      }
      // Calculate median
      if (maxHeap.size() > minHeap.size()) {
        medianStorage.add((double) maxHeap.peek());
      }
      else if (maxHeap.size() == minHeap.size()) {
        medianStorage.add((double) ((long) minHeap.peek() + (long) maxHeap.peek()) * 0.5);
      }
      else {
        throw new RuntimeException("Invalid heap sizes");
      }
      // Increment
      i++;
    }

    return medianStorage.stream()
        .mapToDouble(Double::doubleValue)
        .toArray();
  }


  public static void main(String[] args) {

    int[] arr = {1,3,-1,-3,5,3,6,7};

    int k = 3;

    double[] res = medianSlidingWindow(arr, k);

    System.out.println(Arrays.toString(res));
  }
}
