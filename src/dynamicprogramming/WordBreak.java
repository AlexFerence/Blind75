package dynamicprogramming;

import java.util.List;

public class WordBreak {

  public static boolean wordBreak (String s, List<String> wordDict ) {

    boolean[] dp = new boolean[s.length() + 1];

    dp[s.length()] = true;

    for (int i = s.length() - 1; i >= 0 ;i--) {
      for (String word : wordDict) {
        if (i + word.length() > s.length()) continue;
        // compare the strings
        if (s.substring(i, i + word.length()).equals(word)) {
          dp[i] = dp[i + word.length()];
          if (dp[i]) break;
        }
      }
    }
    // Replace this placeholder return statement with your code
    return dp[0];
  }

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> wordDict = List.of( "oghig","lepe", "vegancookbookcatsandd", "kc", "ra", "le", "ay", "doghi", "nddo", "hway", "at", "mice", "nc", "d", "enapplescreamicecreamed", "h", "ecrea", "nappl", "shp", "kbo", "yc", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescream", "cat", "waycrashpineapplepenapplescreamicecreamed", "tsan", "vegancookbookcatsanddoghighwaycrashpineap", "ganco", "lescr", "sand", "applescreamicecreamed", "vegancookbookcatsanddoghig", "pi", "vegancookbookcatsanddoghighwaycrashpineapp", "cookb", "okcat", "neap", "nap", "oghighwaycrashpineapplepenapplescreamicecreamed", "crashpineapplepenapplescreamicecreamed", "ashpi", "ega","plep", "ice", "ple", "gh", "ghw", "cook", "pl", "app", "ic", "pinea", "hello", "dog", "ook", "lesc", "ddog", "ca", "c", "escr", "penap", "boo", "eami", "ecreamed", "vegancookbookcatsanddoghighwaycrashpi", "igh", "mic", "ganc", "vegancookbookcatsanddoghighwaycrashpineapplepenap", "eappl", "vegancookbookcatsanddoghighway", "ep", "penapple", "b", "ycrashpineapplepenapplescreamicecreamed", "pin", "book", "p", "sa", "okb", "andd", "ayc", "sh", "vegan", "cookbook");
    boolean res = wordBreak(s, wordDict);
    System.out.println(res);
  }
}
