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
    int slow = n;
    int fast = sumOfSquaredDigits(n);
    while (fast != 1 && fast != slow) {
      fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
      slow = sumOfSquaredDigits(sumOfSquaredDigits(slow));
    }
    return fast == 1;
  }

  public static void main(String[] args) {
    boolean res = isHappy(2);
    System.out.println(res);
  }

}
