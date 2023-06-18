package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSums {

  private static class Storage {
    int sum;
    int i;
    int j;
    public Storage(int s, int ii, int jj) {
      this.sum = s;
      this.i = ii;
      this.j = jj;
    }
  }

  public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

    PriorityQueue<Storage> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
    List<List<Integer>> smallestPairs = new ArrayList<>();

    for (int i = 0; i < Math.min(target, list1.length); i++) {
      int sum = list1[i] + list2[0];
      minHeap.add(new Storage(sum, i, 0));
    }

    int counter = 1;
    while (!minHeap.isEmpty() && counter <= target) {

      Storage min = minHeap.poll();
      int i = min.i;
      int j = min.j;

      smallestPairs.add(List.of(list1[i], list2[j]));

      int nextElement = j + 1;

      if (list2.length > nextElement) {
        minHeap.add(new Storage(list1[i] + list2[nextElement], i, nextElement));
      }
      counter++;
    }
    return smallestPairs;
  }

  public static void main(String[] args) {
    int[] list1 = {2,3,9};
    int[] list2 = {1,3,6};
    int k = 5;

    List<List<Integer>> res = kSmallestPairs(list1, list2, k);

    System.out.println(res);

  }


}
