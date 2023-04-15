package twopointers;

import java.util.Arrays;

public class ThreeSum {
  public static boolean findSumOfThree(int[] nums, int target) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      int numOut = nums[i];
      int p1 = i + 1;
      int p2 = nums.length - 1;
      while (p1 < p2) {
        int sum = numOut + nums[p1] + nums[p2];
        if (sum == target) return true;
        else if (sum < target) {
          p1++;
        }
        else {
          p2--;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {3,7,1,2,8,4,5};
    boolean res = findSumOfThree(arr, 12);
    System.out.println(res);
  }
}
