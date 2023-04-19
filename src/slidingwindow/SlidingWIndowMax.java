package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SlidingWIndowMax {

  // There is a more efficient solution using a priority queue
  // This is O(n^2) but with priority queue would be O(nlog(n))
  public static int[] maxSlidingWindow(int[] nums, int w) {
    List<Integer> storage = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    for (int t = 0; t < w; t++) storage.add(nums[t]);
    arr.add(Collections.max(storage));
    for (int i = w; i < nums.length; i++) {
      storage.add(nums[i]);
      storage.remove(Integer.valueOf(nums[i - w]));
      arr.add(Collections.max(storage));
    }
    return arr.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[] nums = {-7,-8,7,5,7,1,6,0};
    int k = 4;
    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }
}
