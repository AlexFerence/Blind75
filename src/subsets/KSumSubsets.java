package subsets;

import java.util.ArrayList;
import java.util.List;

public class KSumSubsets {
  public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {

    List<List<Integer>> lol = new ArrayList<>();

    // Add empty set
    lol.add(new ArrayList<>());

    for (Integer n : setOfIntegers) {
      List<List<Integer>> toAdd = new ArrayList<>();
      for (List<Integer> l : lol) {
        List<Integer> copyL = new ArrayList<>(l);
        copyL.add(n);
        toAdd.add(copyL);
      }
      lol.addAll(toAdd);
    }

    List<List<Integer>> res = new ArrayList<>();

    for (List<Integer> l : lol) {
      int sum = l.stream().mapToInt(Integer::intValue).sum();
      if (sum == targetSum) res.add(l);
    }
    return res;
  }


  public static void main(String[] args) {
    Integer[] temp = {1,2,3,4,5,6};
    ArrayList<Integer> set = new ArrayList<>(List.of(temp));
    int targetSum = 6;
    List<List<Integer>> res = getKSumSubsets(set, targetSum);
    System.out.println(res);
  }
}
