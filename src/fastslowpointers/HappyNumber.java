package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

  public static int sumOfSquaredDigits(int number) {
    int totalSum = 0;
    while (number != 0) {
      int digit = number % 10;
      number = number / 10;
      totalSum += (Math.pow(digit, 2));
    }
    return totalSum;
  }

  public static boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (!seen.contains(n)) {
      int sumOfDig = sumOfSquaredDigits(n);
      if (sumOfDig == 1) {
        return true;
      }
      seen.add(n);
      n = sumOfDig;
    }
    return false;
  }

  public static void main(String[] args) {
    boolean res = isHappy(2);
    System.out.println(res);
  }

}
