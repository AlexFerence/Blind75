package ModifiedBinarySearch;

public class SingleElementInSortedArray {
  public static int singleNonDuplicate(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

      int mid = left + (right - left) / 2;

      // Check if mid is different than both neighbours
      boolean diffThanRight = (mid + 1 >= nums.length) || nums[mid] != nums[mid + 1];
      boolean diffThanLeft = (mid - 1 < 0) || nums[mid] != nums[mid - 1];

      if (diffThanLeft && diffThanRight) {
        return nums[mid];
      }
      else {
        // If the num to the right is the same
        if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
          if ((((right - left + 2) / 2) % 2) == 1) {
            left = mid;
          }
          else {
            right = mid - 1;
          }
        }
        else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
          if ((((right - left + 2) / 2) % 2) == 1) {
            right = mid;
          }
          else {
            left = mid + 1;
          }
        }
        else {
          return mid;
        }
      }

    }

    // replace this placeholder return statement with your code
    return 0;
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2,2,3,3};
    int[] nums2 = {1,1,2,2,3,4,4,5,5};

    int[] nums3 = {1,2,2,3,3,4,4};
    int[] nums4 = {1,1,2,2,3,3,4};

    int[] nums5 = {1,2,2,3,3,4,4,5,5};
    int[] nums6 = {1,1,2,2,3,3,4,4,5};

    int res = singleNonDuplicate(nums6);

    System.out.println(res);

  }
}
