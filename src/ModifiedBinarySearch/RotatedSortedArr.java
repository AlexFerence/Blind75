package ModifiedBinarySearch;

public class RotatedSortedArr {

  public static boolean search(int[] arr, int t) {
    int left = 0;
    int right = arr.length - 1;

    // Find the point where it is the biggest beside the smallest

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] == t) {
        return true;
      }
      // If the left side is sorted and num is in that range
      else if (arr[left] <= arr[mid] && t >= arr[left] && t < arr[mid]) {
        right = mid - 1;
      }
      // If the right side is sorted and the num is in that range
      else if (arr[mid] <= arr[right] && t > arr[mid] && t <= arr[right]) {
        left = mid + 1;
      }
      else if (arr[left] <= arr[mid]) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    if (0 <= left && left < arr.length) {
      return arr[left] == t;
    }
    return false;
  }


  public static void main(String[] args) {
    int[] arr = {22,67,-14,16,19};
    int t = 68;

    boolean res = search(arr, t);

    System.out.println(res);

  }
}
