package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsInString {

  public static String reverseWords(String sentence) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < sentence.length()) {
      if (sentence.charAt(i) != ' ') {
        sb.append(sentence.charAt(i));
      }
      else if (
          i > 0 &&
          sentence.charAt(i) == ' ' &&
          sentence.charAt(i - 1) != ' '
      ) {
        sb.append(sentence.charAt(i));
      }
      i++;
    }

    String[] words = sb.toString().split(" ");
    int p1 = 0;
    int p2 = words.length - 1;
    while (p1 < p2) {
      String w1temp = words[p1];
      words[p1] = words[p2];
      words[p2] = w1temp;
      p1++;
      p2--;
    }
    return String.join(" ", words);
  }

  public static void main(String[] args) {

    System.out.println(reverseWords("Hello   World"));


  }
}
