package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class CircularArray {

  public static boolean circularArrayLoop(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      int slow = i;
      int fast = i;
      fast = (fast + nums[fast]) % nums.length;
      if (fast < 0) {
        fast = fast + nums.length;
      }

      boolean foundEnd = false;

      while (slow != fast) {

        int oldFast = fast;
        fast = (fast + nums[fast]) % nums.length;
        if (fast < 0) {
          fast = fast + nums.length;
        }
        if (oldFast == fast) break;

        oldFast = fast;
        fast = (fast + nums[fast]) % nums.length;
        if (fast < 0) {
          fast = fast + nums.length;
        }
        if (oldFast == fast) break;

        slow = (slow + nums[slow]) % nums.length;
        if (slow < 0) {
          slow = slow + nums.length;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = {-1,-2,-3,-4,-5,6};
    boolean res = circularArrayLoop(arr);
    System.out.println(res);
  }
}
