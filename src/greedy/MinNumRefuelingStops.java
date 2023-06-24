package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumRefuelingStops {

  public static int minRefuelStops(int target, int startFuel, int[][] stations) {

    Arrays.sort(stations, (a,b) -> (b[1] - b[0]) - (a[1] - a[0]));

    List<int[]> listStations = new ArrayList<>(List.of(stations));

    listStations.sort((a,b) -> (b[1] - b[0]) - (a[1] - a[0]));

    int currentFuel = startFuel;
    int stationsVisited = 0;
    int distTravelled = 0;

    while (distTravelled < target) {
      // Find best station - first possible option
      int[] bestStation = null;
      int bestStationIndex = 0;
      for (int i = 0; i < listStations.size(); i++) {
        if (listStations.get(i)[0] <= currentFuel) {
          bestStation = listStations.get(i);
          bestStationIndex = i;
          break;
        }
      }
      if (bestStation == null) {
        return -1;
      }
      currentFuel -= bestStation[0];
      currentFuel += bestStation[1];
      stationsVisited++;
      listStations.remove(bestStationIndex);
      distTravelled += bestStation[0];
    }
    return stationsVisited;
  }

  public static void main(String[] args) {

    int[][] stations = {{2,5}, {3,1}, {6,4}, {12,6}};

    int res = minRefuelStops(15, 3, stations);

    System.out.println(res);

  }
}
