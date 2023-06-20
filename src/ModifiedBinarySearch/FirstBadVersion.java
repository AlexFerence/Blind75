package ModifiedBinarySearch;

import java.util.Arrays;
import java.util.HashMap;

public class FirstBadVersion {

  private static class Api {
    public int n;
    public boolean isBad(int num) {
      return !(num < n);
    }
  }

  static Api versionApi = new Api();

  public static boolean isBadVersion(int v){
    return versionApi.isBad(v);
  }

  public static int[] firstBadVersion(int n) {
    // -- DO NOT CHANGE THIS SECTION
    versionApi.n = 10;
    // --
    int first = 1;
    int last = n;

    HashMap<Integer, Boolean> map = new HashMap<>();

    int apiCallCount = 0;

    int oldMid = -1;

    while (true) {
      int mid = first + (last - first) / 2;

      // Api call the mid
      boolean isBad = isBadVersion(mid);
      map.put(mid, isBad);
      apiCallCount++;

      // Check if index to the left has already been checked
      if (map.containsKey(mid - 1) && map.get(mid - 1) != isBad) {
        return new int[] {mid, apiCallCount};
      }
      else if (map.containsKey(mid + 1) && map.get(mid + 1) != isBad) {
        return new int[] {mid + 1, apiCallCount};
      }

      // No conclusive evidence so shift the pointers
      // If it is bad, shift the pointers left
      if (isBad) {
        last = mid;
      }
      // else not bad, shift pointers right
      else {
        first = mid + 1;
      }
    }
  }

  public static void main(String[] args) {
    int[] res = firstBadVersion(13);
    System.out.println(Arrays.toString(res));
  }

}
