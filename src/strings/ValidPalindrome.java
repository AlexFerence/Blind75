package strings;

import java.util.Locale;

public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        sb.append(Character.toLowerCase(c));
      }
    }
    s = sb.toString();
    int p1 = 0;
    int p2 = s.length() - 1;
    while (p1 < p2) {
      if (s.charAt(p1) != s.charAt(p2)) return false;
      p1++;
      p2--;
    }
    return true;
  }

  public static void main(String[] args) {
    boolean res = isPalindrome("A man, a plan, a canal: Panama");
    System.out.println(res);
  }
}
