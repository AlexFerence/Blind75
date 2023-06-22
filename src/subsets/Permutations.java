package subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static char[] swapChar(String word , int i, int j)
  {
    char[] swapIndex = word.toCharArray();
    char temp = swapIndex[i];
    swapIndex[i] = swapIndex[j];
    swapIndex[j] = temp;
    return swapIndex;
  }

  public static void permuteStringRec(String word, int currentIndex, ArrayList<String> res) {

    // if index at the end of the string then add word
    if (currentIndex == word.length() - 1) {
      res.add(word);
      return;
    }

    for (int i = currentIndex; i < word.length(); i++) {
      // Swap each char for permutation
      char[] swappedStr = swapChar(word, currentIndex, i);

      // Recursive call
      permuteStringRec(new String(swappedStr), currentIndex, res);
    }
  }

  public static ArrayList<String> permuteWord(String word) {

    ArrayList<String> permutations = new ArrayList<>();

    permutations.add(word);

    permuteStringRec(word, 0, permutations);

    return permutations;
  }

  public static void main(String[] args) {
    String str = "kop";
    List<String> res = permuteWord(str);
    System.out.println(res);
  }

}
