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
    List<Integer> pair;
    public Storage(int s, List<Integer> p) {
      this.sum = s;
      this.pair = p;
    }
  }

  public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

    int l1p1 = 0;
    int l1p2 = 1;

    int l2p1 = 0;
    int l2p2 = 1;

    PriorityQueue<Storage> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
    List<List<Integer>> smallestPairs = new ArrayList<>();

    // Add the first element
    if (target > 0) {
      List<Integer> firstElement = new ArrayList();
      firstElement.add(list1[0]);
      firstElement.add(list1[0]);
      smallestPairs.add(firstElement);
    }

    while (smallestPairs.size() < target) {

      int sum1 = list1[l1p1] + list2[l2p2];
      int sum2 = list2[l2p1] + list1[l1p2];

      if (sum1 <= sum2) {

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(list1[l1p1]);
        arr1.add(list1[l2p2]);

        Storage firstIncrement = new Storage(sum1, arr1);

        minHeap.add(firstIncrement);



      }
      else {

      }








    }

    return new ArrayList<>();
  }

  public static void main(String[] args) {
    int[] list1 = {1,2,10,11};
    int[] list2 = {1,2,10,11};
    int k = 5;

    List<List<Integer>> res = kSmallestPairs(list1, list2, k);

    System.out.println(res);

  }


}
