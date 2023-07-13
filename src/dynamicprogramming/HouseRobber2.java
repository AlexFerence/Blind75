package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HouseRobber2 {

  public static int houseRobber(int[] money) {
    int[] arr1 = Arrays.copyOf(money, money.length -1);
    int[] arr2 = Arrays.copyOfRange(money, 1, money.length);

    return Math.max(houseRobberIterative(arr1), houseRobberIterative(arr2));
  }

  public static int houseRobberIterative(int[] money) {
    int[] dp = new int[money.length];

    for (int i = 0; i < money.length; i++) {
      int bestNum = money[i];
      if (i - 1 >= 0) {
        bestNum = Math.max(bestNum, dp[i - 1]);
      }
      if (i - 2 >= 0) {
        bestNum = Math.max(bestNum, dp[i - 2] + money[i]);
      }
      dp[i] = bestNum;
    }
    return dp[money.length - 1];
  }

//  public static int houseRobberRec(int[] money, int index, boolean includedFirstEl) {
//    if (index >= money.length) return 0;
//    if (includedFirstEl && index == money.length - 1) {
//      return houseRobberRec(money, index + 1, false);
//    }
//    int withThisHouse = money[index] + houseRobberRec(money, index + 2, index == 0 || includedFirstEl);
//    int withoutThisHouse = houseRobberRec(money, index + 1, includedFirstEl);
//    return Math.max(withThisHouse, withoutThisHouse);
//  }

  public static void main(String[] args) {
    int[] temp = {1,2,8,4,3,6};
    int res = houseRobber(temp);
    System.out.println(res);
  }

}
