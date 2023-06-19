package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  public static List<Integer> topKFrequent(int[] arr, int k) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int n : arr) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

    for (int key : map.keySet()) {
      int[] element = {map.get(key), key};
      if (minHeap.size() < k) {
        minHeap.add(element);
      }
      else if (minHeap.size() > 0 && element[0] > minHeap.peek()[0]) {
        minHeap.poll();
        minHeap.add(element);
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int[] temp : minHeap) {
      res.add(temp[1]);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,1,1,3,3,4,2,3,1};
    List<Integer> res = topKFrequent(arr, 2);
    System.out.println(res);
  }
}
