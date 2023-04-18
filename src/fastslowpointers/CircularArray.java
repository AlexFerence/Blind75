package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class CircularArray {

  private static int nextIndex(int[] nums, int index) {
    int n = nums.length;
    int nextIndex = (index + nums[index]) % n;
    if (nextIndex < 0) {
      nextIndex += n;
    }
    return nextIndex;
  }

  public static boolean circularArrayLoop(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int slow = i;
      int fast = nextIndex(nums, i);
      boolean foundLoop = false;

      boolean isPositive = nums[fast] >= 0;

      while (slow != fast) {
        if (fast == nextIndex(nums,fast)) {
          break;
        }
        fast = nextIndex(nums, fast);
        boolean newIsPositive1 = nums[fast] >= 0;

        if (newIsPositive1 != isPositive) break;

        if (fast == nextIndex(nums,fast)) break;

        fast = nextIndex(nums, fast);

        boolean newIsPositive2 = nums[fast] >= 0;

        if (newIsPositive2 != newIsPositive1) break;

        slow = nextIndex(nums, slow);
        if (fast == slow) {
          foundLoop = true;
          break;
        }
      }
      if (foundLoop) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {1,-1,5,1,4};
    boolean res = circularArrayLoop(arr);
    System.out.println(res);
  }
}
