package slidingwindow;

import java.util.HashMap;

public class MinWindowSubstring {


  public static boolean validWindowForRequred(
      HashMap<Character, Integer> required,
      HashMap<Character, Integer> window) {
    if (required.size() > window.size()) return false;
    for (Character c : required.keySet()) {
      int windowCount = window.getOrDefault(c, 0);
      int requiredCount = required.get(c);
      if (windowCount < requiredCount) return false;
    }
    return true;
  }

  public static String minWindow(String s, String t) {

    HashMap<Character, Integer> required = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    // Populate required map
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      required.put(c, required.getOrDefault(c, 0) + 1);
    }

    int minSize = Integer.MAX_VALUE;
    String minString = "";

    int startWindowIndex = 0;

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

      if (validWindowForRequred(required, window)) {
        // traverse backwards
        int end = i + 1;
        // Pop chars from the left untill the window is invalid
        while (validWindowForRequred(required, window)) {
          char leftMostChar = s.charAt(startWindowIndex);
          window.put(leftMostChar, window.get(leftMostChar) - 1);
          if (window.get(leftMostChar) == 0) window.remove(leftMostChar);
          if (!validWindowForRequred(required, window)) break;
          startWindowIndex++;
        }

        int windowSize = end - startWindowIndex;
        if (windowSize < minSize) {
          minSize = windowSize;
          minString = s.substring(startWindowIndex, end);
        }
        startWindowIndex++;
      }
    }

    return minString;
  }

  public static void main(String[] args) {

    minWindow("ABAACBBA", "ABC");

  }
}
