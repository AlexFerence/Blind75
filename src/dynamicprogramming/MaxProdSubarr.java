package dynamicprogramming;

public class MaxProdSubarr {

  public static int maxProduct(int [] nums) {
    int currMin = nums[0];
    int currMax = nums[0];
    int maxProd = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int c = nums[i];
      int oldCurrMin = currMin;
      currMin = Math.min(currMin * c, Math.min(currMax * c, c));
      currMax = Math.max(currMax * c, Math.max(oldCurrMin * c, c));
      maxProd = Math.max(maxProd, currMax);
    }
    return maxProd;
  }

  public static void main(String[] args) {
    int[] nums = {2, -5, 3, 1, -4, 0, -10, 2};
    int res = maxProduct(nums);
    System.out.println(res);

  }
}
