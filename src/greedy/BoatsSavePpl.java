package greedy;

import java.util.Arrays;

public class BoatsSavePpl {

  public static int rescueBoats(int[] people, int limit) {

    Arrays.sort(people);

    int left = 0;
    int right = people.length - 1;

    int boatCounter = 0;

    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        boatCounter++;
        left++;
        right--;
      }
      else {
        boatCounter++;
        right--;
      }
    }
    return boatCounter;
  }

  public static void main(String[] args) {
    int[] ppl = {3,4,5,3,4};
    int limit = 6;
    int res = rescueBoats(ppl, limit);
    System.out.println(res);
  }

}
