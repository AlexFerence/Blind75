package dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

  public static int coinChange(int[] coins, int total) {

    int[] dp = new int[total];
    Arrays.fill(dp, -1);



    // Write your code here

    return -1;
  }

  public static void main(String[] args) {
    int[] coins = {2,3,5};
    int target = 9;
    int res = coinChange(coins, target);
    System.out.println(res);
  }

}
