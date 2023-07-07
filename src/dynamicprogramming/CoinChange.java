package dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

  public static int coinChange(int[] coins, int total) {
    int[] dp = new int[total + 1];
    Arrays.fill(dp, -1);
    for (int i = 0; i <= total; i++) {
      int tempMin = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin == i) {
          dp[i] = 1;
          break;
        }
        else if (i - coin > 0 && dp[i - coin] > 0) {
          tempMin = Math.min(tempMin, 1 + dp[i - coin]);
        }
      }
      if (dp[i] != 1 && tempMin != Integer.MAX_VALUE) {
        dp[i] = tempMin;
      }
    }
    return dp[total];
  }

  public static void main(String[] args) {
    int[] coins = {2,3,5};
    int target = 9;
    int res = coinChange(coins, target);
    System.out.println(res);
  }

}
