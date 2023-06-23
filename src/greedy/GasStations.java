package greedy;

import java.util.Arrays;

public class GasStations {

  public static int gasStationJourney(int[] gas, int[] cost) {
    if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
    // If it makes it here then there must be one possible start index
    int startIndex = 0;
    int currGas = 0;
    for (int index = 0; index < gas.length; index++) {
      currGas = currGas + gas[index] - cost[index];
      if (currGas < 0) {
        currGas = 0;
        startIndex = index + 1;
      }
    }
    return startIndex;
  }

  public static void main(String[] args) {
    int[] gas = {2, 3, 4};
    int[] cost = {3, 4, 3};
    int res = gasStationJourney(gas,cost);
    System.out.println(res);
  }

}
