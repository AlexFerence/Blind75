package arrays;

public class BuySellStockCooldown {

  public static int maxProfit(int[] prices) {



    return 0;
  }

  public static void main(String[] args) {
    // Test cases
    int[] prices1 = {0,2,3,4,2,1,0,5}; // Should be 9 - cooldown during the decline
    int[] prices2 = {0,5,0,10}; // Should be 6 - avoid first buy so you can use second interval
    int[] prices3 = {0,5,0,10,0,15}; // Should be 20 - avoids buying the middle interval

    // Reminds me of graph coloring

    // Use dynamic programming for this

  }
}
