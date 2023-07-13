package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {

  public static List<List<Integer>> combinationSum(int[] nums, int target) {

    Arrays.sort(nums);

    HashMap<Integer, List<List<Integer>>> accumulator = new HashMap<>();

    int[][] dp = new int[nums.length + 1][target + 1];

    for (int y = 1; y <= nums.length; y++) {
      for (int x = 1; x <= target; x++) {
        int aboveCount = dp[y-1][x];
        List<List<Integer>> aboveList = new ArrayList<>();

        if (accumulator.containsKey(x)) {
          aboveList.addAll(accumulator.get(x));
        }

        if (nums[y-1] == x) {
          dp[y][x] = 1 + aboveCount;
          aboveList.add(List.of(nums[y-1]));
        }
        else if (accumulator.containsKey(x - nums[y-1])) {
          List<List<Integer>> temp = new ArrayList<>(accumulator.get(x - nums[y-1]));
          for (List<Integer> arr : temp) {
            List<Integer> arrCopy = new ArrayList<>(arr);
            arrCopy.add(nums[y-1]);
            aboveList.add(arrCopy);
          }
        }
        accumulator.put(x, aboveList);
      }
    }
    List<List<Integer>> res = new ArrayList<>();
    res = accumulator.get(target);

    // sort based on the first element of each list
    // if they are the same check the second element, then the third etc
    res.sort((a, b) -> {
      int i = 0;
      while (i < a.size() && i < b.size()) {
        if (a.get(i) != b.get(i)) {
          return a.get(i) - b.get(i);
        }
        i++;
      }
      return 0;
    });

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {3,4,5,6};
    int target = 9;
    List<List<Integer>> res = combinationSum(nums, target);
    System.out.println(res);
  }
}
