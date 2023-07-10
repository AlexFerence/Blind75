package dynamicprogramming;

public class CountingBits {

  public static int closestSmallerPowerOf2(int n) {
    int res = 0;
    while (n > 0) {
      n = n >> 1;
      res++;
    }
    return res - 1;
  }

  public static int[] countingBits(int n) {

    if (n == 0) return new int[]{0};

    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      int temp = i;
      int closestSmallerPowerOf2= closestSmallerPowerOf2(temp);
      temp = temp - (int) Math.pow(2, closestSmallerPowerOf2);
      dp[i] = 1 + dp[temp];
    }

    return dp;
  }

  public static void main(String[] args) {
    System.out.println(closestSmallerPowerOf2(18));
  }
}
