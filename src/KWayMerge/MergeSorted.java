package KWayMerge;

import java.util.Arrays;

public class MergeSorted {

  // IMPORTANT - fill from BACK to FRONT
  public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

    int p1 = m - 1, p2 = n - 1;

    int p = m + n - 1;

    while (p1 >= 0 || p2 >=0) {
      if (p1 < 0) {
        nums1[p] = nums2[p2];
        p2--;
      }
      else if (p2 < 0) {
        break;
      }
      else if (nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1];
        p1--;
      }
      else if (nums1[p1] <= nums2[p2]) {
        nums1[p] = nums2[p2];
        p2--;
      }
      p--;
    }
    return nums1;
  }

  public static void main(String[] args) {
    int[] n1 = {1,2,3,0,0,0};
    int[] n2 = {4,5,6};
    int m = 3;
    int n = 3;
    int[] res = mergeSorted(n1, m, n2, n);
    System.out.println(Arrays.toString(res));
  }


}
