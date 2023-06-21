package subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subsets2 {

  public static List<List<Integer>> findAllSubsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    for (int n : nums) {
      List<List<Integer>> subsetsToAdd = new ArrayList<>();
      for (List<Integer> l : res) {
        List<Integer> copyL = new ArrayList<>(l);
        copyL.add(n);
        subsetsToAdd.add(copyL);
      }
      res.addAll(subsetsToAdd);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {2,5,7};
    List<List<Integer>> res = findAllSubsets(arr);
    System.out.println(res);
  }
}
