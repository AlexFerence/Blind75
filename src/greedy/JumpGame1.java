package greedy;

public class JumpGame1 {
  public static boolean jumpGame(int[] nums) {
    int furthestReachable = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > furthestReachable) return false;
      furthestReachable = Math.max(furthestReachable, nums[i] + i);
      if (furthestReachable >= nums.length - 1) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 0, 4};
    boolean res = jumpGame(nums);
    System.out.println(res);
  }
}
