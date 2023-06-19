package ModifiedBinarySearch;

public class BinarySearch {

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      // Prevents overflow
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) return mid;
      else if (nums[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,5,9};
    int res = search(arr, 9);
    System.out.println(res);
  }

}
