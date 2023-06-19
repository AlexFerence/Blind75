package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRotatedSortedArr {

  public static int binarySearchRotated(List<Integer> nums, int target) {

    int left = 0;
    int right = nums.size() - 1;

    // Find the point where it is the biggest beside the smallest

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums.get(mid) == target) {
        return mid;
      }
      // If the left side is sorted and num is in that range
      else if (nums.get(left) <= nums.get(mid) && target >= nums.get(left) && target < nums.get(mid)) {
        right = mid - 1;
      }
      // If the right side is sorted and the num is in that range
      else if (nums.get(mid) <= nums.get(right) && target > nums.get(mid) && target <= nums.get(right)) {
        left = mid + 1;
      }
      else if (nums.get(left) <= nums.get(mid)) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return -1;
  }


  public static void main(String[] args) {
    Integer[] arr = {5,6,3,4};
    List<Integer> l = Arrays.asList(arr);
    int res = binarySearchRotated(l, 5);
    System.out.println(res);
  }
}
