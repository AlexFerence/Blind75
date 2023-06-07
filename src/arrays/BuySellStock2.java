package arrays;

public class BuySellStock2 {
  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int prevPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      maxProfit += Math.max(0, prices[i] - prevPrice);
      prevPrice = prices[i];
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] temp = {1,2,3,4,5};
    int res = maxProfit(temp);
    System.out.println(res);

  }
}
