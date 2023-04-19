package slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DNARepeated {

  public static List<String> findRepeatedDnaSequences(String s) {
    Set<String> set = new HashSet<>();
    Set<String> duplicates = new HashSet<>();
    for (int i = 0; i < s.length() - 10; i++) {
      String window = s.substring(i, i + 10);
      if (set.contains(window)) {
        duplicates.add(window);
      }
      set.add(window);
    }
    return new ArrayList<>(duplicates);
  }

  public static void main(String[] args) {

    System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));

  }


}
