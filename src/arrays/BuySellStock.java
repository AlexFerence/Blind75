package arrays;

public class BuySellStock {

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int lowestPriceSeen = prices[0];
    for (int i = 0; i < prices.length; i++) {
      int currentPrice = prices[i];
      if (currentPrice < lowestPriceSeen) {
        lowestPriceSeen = currentPrice;
      }
      maxProfit = Math.max(maxProfit, currentPrice - lowestPriceSeen);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] testArr = {7,6,5,4,3,2,1};
    int res = maxProfit(testArr);
    System.out.println(res);
  }
}
