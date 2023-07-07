package dynamicprogramming;

public class Tribonacci {

  public static int findTribonacci(int n) {

    int[] dp = new int[n + 1];

    dp[0] = 0;
    if (n == 0) return 0;
    dp[1] = 1;
    if (n == 1) return 1;
    dp[2] = 1;
    if (n == 2) return 1;

    if (n < 3) return dp[n];

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int n = 10;
    int res = findTribonacci(n);
    System.out.println(res);
  }
}
