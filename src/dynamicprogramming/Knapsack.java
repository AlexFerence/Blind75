package dynamicprogramming;

import java.util.Arrays;

public class Knapsack {

  public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
    // Your code will replace the placeholder below
    int[][] dp = new int[values.length + 1][capacity + 1];

    for (int[] temp : dp) {
      Arrays.fill(temp, -1);
    }

    return knapsackRecTopDown(capacity, weights, values, weights.length - 1, dp);
  }

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

  public static void main(String[] args) {
    int[] weights = {3,5,2,7};
    int[] value = {3,4,5,1};
    int capacity = 7;
    int res = findMaxKnapsackProfit(capacity, weights, value);
    System.out.println(res);
    // should output 8
  }
}
