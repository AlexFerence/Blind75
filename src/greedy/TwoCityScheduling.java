package greedy;

import java.util.Arrays;
import java.util.List;

public class TwoCityScheduling {

  public static int twoCityScheduling(int[][] costs) {
    Arrays.sort(costs, (a,b) -> (a[0] - a[1]) - (b[0] - b[1]));
    int left = 0;
    int right = costs.length - 1;
    int sum = 0;
    while (left < right) {
      sum += (costs[left][0] + costs[right][1]);
      left++;
      right--;
    }
    return sum;
  }

  public static void main(String[] args) {
    // Sum should be 6
    int[][] costs = {{1,2}, {3,1}, {6,2}, {2,3}};

    int res = twoCityScheduling(costs);

    System.out.println(res);

  }
}
