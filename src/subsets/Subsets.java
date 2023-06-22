package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static List<List<Integer>> findAllSubsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    res.add(new ArrayList<>());

    for (int num : nums) {
      List<List<Integer>> toAdd = new ArrayList<>();

      for (List<Integer> existingList : res) {
        List<Integer> listCopy = new ArrayList<>(existingList);
        listCopy.add(num);
        toAdd.add(listCopy);
      }
      res.addAll(toAdd);

    }


    return res;
  }


}
