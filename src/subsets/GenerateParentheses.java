package subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  public static void generateCombinationsRec(int n, int forwardPar, String currWord, ArrayList<String> res) {
    // If word.length == n x 2 return
    if (currWord.length() == n * 2) {
      res.add(currWord);
      return;
    }
    // Else add a parentheses or close the parentheses
    if (forwardPar < n) {
      generateCombinationsRec(n, forwardPar + 1, currWord + "(", res);
    }
    int backwardParCount = currWord.length() - forwardPar;
    if (backwardParCount < forwardPar) {
      generateCombinationsRec(n, forwardPar, currWord + ")", res);
    }
  }

  public static ArrayList<String> generateCombinations(int n) {
    ArrayList<String> result = new ArrayList<>();
    generateCombinationsRec(n, 0, "", result);
    return result;
  }

  public static void main(String[] args) {
    int n = 3;
    List<String> res = generateCombinations(n);
    System.out.println(res);
  }


}
