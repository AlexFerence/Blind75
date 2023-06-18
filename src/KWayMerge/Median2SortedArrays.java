package KWayMerge;

public class Median2SortedArrays {

  public static float findMedian(int[] nums1, int[] nums2) {

    int[] longerArr;
    int[] shorterArr;

    if (nums1.length > nums2.length) {
      longerArr = nums1;
      shorterArr = nums2;
    }
    else {
      longerArr = nums2;
      shorterArr = nums1;
    }

    // Pick the middle of the longer array
    int leftLong = longerArr.length / 2;
    int rightLong = (longerArr.length / 2) + 1;

    // Your code will replace this placeholder return statement

    return 0;
  }

  public static void main(String[] args) {

  }
}
