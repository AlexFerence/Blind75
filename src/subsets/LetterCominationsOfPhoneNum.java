package subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCominationsOfPhoneNum {

  public static List<String> letterCombinations(String digits) {

    HashMap<Character, String> lookup = new HashMap<>();
    lookup.put('1', "");
    lookup.put('2', "abc");
    lookup.put('3', "def");
    lookup.put('4', "ghi");
    lookup.put('5', "jkl");
    lookup.put('6', "mno");
    lookup.put('7', "pqrs");
    lookup.put('8', "tuv");
    lookup.put('9', "wxyz");

    List<String> res = new ArrayList<>();

    for (int i = 0; i < digits.length(); i++) {
      List<String> toAdd = new ArrayList<>();
      String possibleLetters = lookup.get(digits.charAt(i));
      for (int x = 0; x < possibleLetters.length(); x++) {
        char c = possibleLetters.charAt(x);
        if (res.size() == 0) {
          toAdd.add(c + "");
        }
        else {
          for (String s : res) {
            String newStr = s + c;
            toAdd.add(newStr);
          }
        }
      }
      res = toAdd;
    }

    return res;
  }

  public static void main(String[] args) {

    String s = "34";

    List<String> res = letterCombinations(s);

    System.out.println(res);

  }
}
