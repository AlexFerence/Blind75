package greedy;

import java.util.Arrays;

public class JumpGame2 {

  public static int jumpGame2(int[] nums) {
    int farthestJump = 0;
    int currentJump = 0;
    int jumps = 0;

    for (int i = 0; i < nums.length; i++) {
      farthestJump = Math.max(farthestJump, i + nums[i]);
      if (i == currentJump) {
        jumps++;
        currentJump = farthestJump;
      }
      if (currentJump >= nums.length - 1) break;
    }

    return jumps;
  }


  public static int jump(int[] nums) {

    int furthestJump = 0;
    int currentJump = 0;
    int jumps = 0;

    for (int i = 0; i < nums.length; i++) {
      furthestJump = Math.max(furthestJump, i + nums[i]);
      if (i == furthestJump) {
        jumps++;
        currentJump = furthestJump;
      }
      if (currentJump >= nums.length - 1) break;
    }

    return jumps;
  }

  public static void main(String[] args) {
    int[] arr = {2,9,1,1,1,1};
    int res = jumpGame2(arr);
    System.out.println(res);
  }
}
