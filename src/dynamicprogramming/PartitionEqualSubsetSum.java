package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PartitionEqualSubsetSum {

  public static boolean canPartitionArray(int[] arr) {
    // Write your code here
    int totalSum = Arrays.stream(arr).sum();

    if (totalSum % 2 == 1) return false;

    int target = totalSum / 2;

    HashSet<Integer> set = new HashSet<>();

    set.add(0);

    for (int a : arr) {
      List<Integer> toAdd = new ArrayList<>();
      for (int s : set) {
        toAdd.add(a + s);
      }
      set.addAll(toAdd);
    }

    return set.contains(target);
  }

  public static void main(String[] args) {

    int[] arr = {1,5,11,5};
    boolean res = canPartitionArray(arr);
    System.out.println(res);

  }
}
