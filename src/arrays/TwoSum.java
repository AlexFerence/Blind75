package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

  // Assume each input has exactly one solution
  public static int[] twoSum(int[] nums, int target) {
    // Map stores value, array index
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      int desired = target - currentNum;
      if (map.containsKey(desired)) {
        return new int[]{map.get(desired), i};
      }
      map.put(currentNum, i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] arr = {3,3};
    int target = 6;
    int[] res = twoSum(arr, target);
    System.out.println(Arrays.toString(res));
  }

}
