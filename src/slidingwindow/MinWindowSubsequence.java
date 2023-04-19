package slidingwindow;

public class MinWindowSubsequence {

  // Find window the encompasses all letters,
  // Backtrack on that window to see if there is an easier solution

  public static String minWindow(String s, String t) {
    int sPtr = 0;
    int tPtr = 0;

    String minString = "";
    int minLen = Integer.MAX_VALUE;

    while (sPtr < s.length() && tPtr < t.length()) {
      char sChar = s.charAt(sPtr);
      char tChar = t.charAt(tPtr);
      if (sChar == tChar) {
        tPtr++;
      }
      sPtr++;

      // If we made it to the end of the second word
      if (tPtr == t.length()) {
        // backtrack
        int end = sPtr;
        int start = end - 1;
        tPtr--;
        while (start >= 0) {
          char startChar = s.charAt(start);
          tChar = t.charAt(tPtr);

          if (startChar == tChar) tPtr--;

          if (tPtr < 0) {
            // might be - 1
            int len = end - start;

            if (len < minLen) {
              minLen = len;
              // Included start index but not end index
              minString = s.substring(start, end);
            }
            break;
          }

          start--;
        }
        tPtr++;
        sPtr = start + 1;

      }
    }
    return minString;
  }

  public static void main(String[] args) {
    String s = "azjsksfztfs";
    String t = "sz";

    System.out.println(minWindow(s,t));


  }
}
