package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInMSortedLists {
  public static int kSmallestNumber(List<List<Integer>> lists, int k) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));
    // Add the first element of each list into a min heap
    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i).size() > 0) {
        int firstEl = lists.get(i).get(0);
        int[] temp = {firstEl, i};
        minHeap.add(temp);
        lists.get(i).remove(0);
      }
    }

    int currentSmallestEl = 0;
    for (int i = 0; i < k; i++) {
      int[] topOfHeap = minHeap.poll();
      if (topOfHeap == null) {
        break;
      }
      currentSmallestEl = topOfHeap[0];
      int arrayIndex = topOfHeap[1];
      if (lists.get(arrayIndex).size() > 0) {
        int newValue = lists.get(arrayIndex).get(0);
        int[] temp = {newValue, arrayIndex};
        minHeap.add(temp);
        lists.get(arrayIndex).remove(0);
      }
    }
    return currentSmallestEl;
  }


  public static void main(String[] args) {
    ArrayList<Integer> firstList = new ArrayList<>();
    firstList.add(1);
    firstList.add(4);
    firstList.add(5);

    ArrayList<Integer> secondList = new ArrayList<>();
    secondList.add(4);
    secondList.add(7);
    secondList.add(8);

    ArrayList<Integer> thirdList = new ArrayList<>();
    thirdList.add(2);
    thirdList.add(6);
    thirdList.add(9);

    List<List<Integer>> lol = new ArrayList<>();
    lol.add(firstList);
    lol.add(secondList);
    lol.add(thirdList);

    int k = 5;

    int res = kSmallestNumber(lol, k);

    System.out.println(res);
  }

}
