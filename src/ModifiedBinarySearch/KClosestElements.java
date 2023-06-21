package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

  // Return k number of integers closest to target
  public static List<Integer> findClosestElements(int[] nums, int k, int target) {

    List<Integer> res = new ArrayList<>();

    if (target >= nums[nums.length - 1]) {
      // return the last k numbers of the array
      for (int i = nums.length - 1; i >= k; i--) {
        res.add(0, nums[i]);
      }
      return res;
    }

    // If target is smaller than smallest arr
    if (target <= nums[0]) {
      for (int i = 0; i < k; i++) {
        res.add(nums[i]);
      }
      return res;
    }

    // Else find where it is supposed to go
    int idealIndex = BinarySearch.binarySearch(nums, target);

    int lPointer = idealIndex - 1;
    int rPointer = idealIndex + 1;

    res.add(nums[idealIndex]);

    while (res.size() < k) {
      int lDistToTarget = Integer.MAX_VALUE;
      int rDistToTarget = Integer.MAX_VALUE;
      if (lPointer > -1) lDistToTarget = Math.abs(target - nums[lPointer]);
      if (rPointer < nums.length) rDistToTarget = Math.abs(target - nums[rPointer]);

      if (lDistToTarget <= rDistToTarget) {
        res.add(0, nums[lPointer]);
        lPointer--;
      }
      else {
        res.add(nums[rPointer]);
        rPointer++;
      }

    }

    return res;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> res = findClosestElements(arr, 4, 3);
    System.out.println(res);
  }

}
