package backtracking;

import com.sun.source.doctree.SeeTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIPAddr {

  public static List<String> restoreIpAddresses(String s) {
    return restoreRec(s, "", 0, 0);
  }

  public static boolean validNum(String nStr) {
    if (nStr.equals("")) return false;
    int n = Integer.parseInt(nStr);
    if (n == 0 && nStr.length() > 1) return false;
    if (nStr.charAt(0) == '0' && n > 0) return false;
    return n >= 0 && n <= 255;
  }

  public static List<String> restoreRec(String s, String acc, int i, int numCount) {
    String first = "";
    String second = "";
    String third = "";
    if (i < s.length()) first = "" + s.charAt(i);
    if (i + 1 < s.length()) second = "" + s.charAt(i) + s.charAt(i + 1);
    if (i + 2 < s.length()) third = "" + s.charAt(i) + s.charAt(i + 1) + s.charAt(i + 2);

    if (numCount == 4) {
      if (i == s.length()) {
        String removedPoint = acc.substring(0, acc.length() - 1);
        return new ArrayList<>(List.of(removedPoint));
      }
    }

    Set<String> sum = new HashSet<>();
    if (validNum(first)) {
      sum.addAll(restoreRec(s, acc + first + ".", i + 1, numCount + 1));
    }
    if (validNum(second)) {
      sum.addAll(restoreRec(s, acc + second + ".", i + 2, numCount + 1));
    }
    if (validNum(third)) {
      sum.addAll(restoreRec(s, acc + third + ".", i + 3, numCount + 1));
    }
    return new ArrayList<>(sum);
  }

  public static void main(String[] args) {
    String test = "010010";
    List<String> res = restoreIpAddresses(test);
    System.out.println(res);
  }

}
