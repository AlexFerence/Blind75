package slidingwindow;

public class MinSubArray {
  public static int minSubArrayLen(int target, int[] arr) {
    // your code will replace this placeholder return statement
    int minSubArr = -1;
    int currWindowSum = 0;
    int start = 0;

    for (int i = 0; i < arr.length; i++) {
      currWindowSum += arr[i];
      if (currWindowSum >= target) {
        int windowSize = i - start + 1;
        if (windowSize < minSubArr || minSubArr == -1) {
          minSubArr = windowSize;
        }
        while (currWindowSum >= target) {
          currWindowSum -= arr[start];
          start++;
          windowSize = i - start + 1;
          if (currWindowSum >= target && windowSize < minSubArr || minSubArr == -1) {
            minSubArr = windowSize;
          }
        }
      }
    }
    return Math.max(minSubArr, 0);
  }

  public static void main(String[] args) {
    int[] nums = {2,3,1,2,4,3};
    System.out.println(minSubArrayLen(7, nums));
  }
}
