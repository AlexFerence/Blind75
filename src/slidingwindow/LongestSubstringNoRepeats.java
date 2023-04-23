package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeats {
  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (map.containsKey(curChar)) {
        if (map.get(curChar) >= start) {
          maxLen = Math.max(maxLen, i - start);
          start = map.get(s.charAt(i)) + 1;
        }
      }
      map.put(s.charAt(i), i);
    }

    return Math.max(maxLen, s.length() - start);
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("a"));
  }
}
