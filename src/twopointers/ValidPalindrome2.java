package twopointers;

public class ValidPalindrome2 {

  public static boolean validPalindrome(String s) {
    int p1 = 0;
    int p2 = s.length() - 1;
    int skipCount = 0;
    while (p1 < p2) {
      if (s.charAt(p1) != s.charAt(p2)) {
        // try skipping one where p2--
        p2--;
        skipCount++;
        if (skipCount > 1) {
          break;
        }
      }
      p1++;
      p2--;
    }
    if (skipCount == 0) return true;

    p1 = 0;
    p2 = s.length() - 1;
    skipCount = 0;
    while (p1 < p2) {
      if (s.charAt(p1) != s.charAt(p2)) {
        // try skipping one where p1++
        p1++;
        skipCount++;
        if (skipCount > 1) {
          break;
        }
      }
      p1++;
      p2--;
    }
    return false;
  }


  public static void main(String[] args) {
    boolean res = validPalindrome("abc");
    System.out.println(res);
  }
}
