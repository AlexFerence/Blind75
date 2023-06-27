package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinNumRefuelingStops {

  public static int minRefuelStops(int target, int startFuel, int[][] stations) {

    // Read the question!!! the stations distance is sorted!!!!!
    int numStops = 0;
    int currentFuel = startFuel;
    int i = 0;

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    if (startFuel > target) return numStops;

    while (currentFuel < target) {
      if (i < stations.length && stations[i][0] <= currentFuel) {
        maxHeap.add(stations[i][1]);
        i++;
      }
      else if (maxHeap.isEmpty()) {
        return -1;
      }
      else {
        currentFuel += maxHeap.poll();
        numStops++;
      }
    }
    return numStops;
  }

  public static void main(String[] args) {

    int[][] stations = {{9,12}, {11,7}, {13,16}, {21,18}, {47,6}};

    int res = minRefuelStops(59, 14, stations);

    System.out.println(res);

  }
}
