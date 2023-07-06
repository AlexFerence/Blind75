package dynamicprogramming;

import java.util.Arrays;

public class Knapsack {

  public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
    return knapsackRecBottomUp(capacity, weights, values);
  }

  public static int knapsackRecBottomUp(int capacity, int[] weights, int[] values) {

    int[][] dp = new int[values.length + 1][capacity + 1];

    for (int i = 1; i <= weights.length; i++) {
      for (int c = 1; c <= capacity; c++) {
        // Get the value from the row above
        int valWithoutItem = dp[i - 1][c];
        int valWithItem = 0;
        if (c - weights[i - 1] >= 0) {
          valWithItem = values[i - 1] + dp[i - 1][c - weights[i - 1]];
        }
        dp[i][c] = Math.max(valWithoutItem, valWithItem);
      }
    }
    return 0;
  }


  public static void main(String[] args) {
    int[] weights = {2,3,4,5};
    int[] value = {1,2,5,6};
    int capacity = 8;
    int res = findMaxKnapsackProfit(capacity, weights, value);
    System.out.println(res);
    // should output 8
  }

  public static int prepareKnapsackTopDown(int capacity, int[] weights, int[] values) {
    int[][] dp = new int[values.length + 1][capacity + 1];

    for (int[] temp : dp) {
      Arrays.fill(temp, -1);
    }
    return knapsackRecTopDown(capacity, weights, values, weights.length - 1, dp);
  }

  // needs matrix filled with -1's
  public static int knapsackRecTopDown(int capacity, int[] weights, int[] values, int i, int[][] dp) {
    if (i == -1 || capacity == 0) {
      return 0;
    }

    // If this case has already been solved then return that value
    if (dp[i][capacity] != -1) return dp[i][capacity];

    // Else if it hasnt been solved yet then calculate and set in the table
    if (weights[i] > capacity) {
      return dp[i][capacity] = knapsackRecTopDown(capacity, weights, values, i - 1, dp);
    }

    return  dp[i][capacity] = Math.max(
        knapsackRecTopDown(capacity, weights, values, i - 1, dp),
        values[i] + knapsackRecTopDown(capacity - weights[i], weights, values, i - 1, dp)
    );
  }

  public static int knapsackRec(int capacity, int[] weights, int[] values, int i) {
    if (i == -1 || capacity == 0) {
      return 0;
    }
    // If weight of this item is larger than the current capacity
    if (weights[i] > capacity) {
      return knapsackRec(capacity, weights, values, i - 1);
    }

    return Math.max(
        knapsackRec(capacity, weights, values, i - 1),
        values[i] + knapsackRec(capacity - weights[i], weights, values, i - 1)
    );

  }
}
