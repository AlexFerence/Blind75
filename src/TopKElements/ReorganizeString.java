package TopKElements;

import java.util.HashMap;

public class ReorganizeString {

  private static class Storage {
    int count;
    char letter;
  }

  public static String reorganizeString(String string1) {
    HashMap<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < string1.length(); i++) {
      char c = string1.charAt(i);
      frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }

    return "";
  }

  public static void main(String[] args) {

    String s = "aaabc";

    String res = reorganizeString(s);

    System.out.println(res);

  }
}
