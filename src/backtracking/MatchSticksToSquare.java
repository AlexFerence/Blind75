package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MatchSticksToSquare {

  public static boolean matchstickToSquare(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    double sqrt = sum / 4;
    if (sum % 4 != 0) return false;

    // If any stick is greater than the sidelength then return false
    for (int n : nums) if (n > sqrt) return false;

    List<Integer> count = new ArrayList<>(List.of(0,0,0,0));

    return matchRec(count, nums, 0, sqrt);
  }

  public static boolean matchRec(List<Integer> count, int[] nums, int numsIndex, double sideLen) {

    // Validate count
    boolean validCount = true;
    for (int c : count) {
      if (c > sideLen) {
        validCount = false;
      }
    }
    if (!validCount) return false;

    if (numsIndex == nums.length) {
      return true;
    }

    // Try in all 4 spots
    boolean foundVal = false;

    for (int i = 0; i < 4; i++) {
      List<Integer> countCopy = new ArrayList<>(count);
      countCopy.set(i, countCopy.get(i) + nums[numsIndex]);
      foundVal = foundVal || matchRec(countCopy, nums, numsIndex + 1, sideLen);
    }
    return foundVal;
  }

  public static void main(String[] args) {
    int[] i = {3, 3, 3, 3, 4};
    boolean res = matchstickToSquare(i);
    System.out.println(res);
  }


}
