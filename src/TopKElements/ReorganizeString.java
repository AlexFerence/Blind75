package TopKElements;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

  private static class Storage {
    int count;
    char letter;
    public Storage(int count, char letter) {
      this.count = count;
      this.letter = letter;
    }
  }

  public static String reorganizeString(String string1) {
    // Make hashmap with the frequency of all the characters
    HashMap<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < string1.length(); i++) {
      char c = string1.charAt(i);
      frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }

    // Add all the frequencies and characters to max heap
    PriorityQueue<Storage> maxHeap = new PriorityQueue<>((a,b) -> b.count - a.count);

    for (char c : frequency.keySet()) {
      int count = frequency.get(c);
      maxHeap.add(new Storage(count, c));
    }

    // Check if there is a valid combination of letters
    Storage max = maxHeap.peek();

    int otherLettersTotal = 0;
    for (char c : frequency.keySet()) {
      if (c != max.letter) {
        otherLettersTotal += frequency.get(c);
      }
    }

    if (otherLettersTotal < max.count-1) {
      return "";
    }

    // Iterate through max heap and pop a character off
    Storage prevElement = null;
    StringBuilder sb = new StringBuilder();

    while (maxHeap.size() > 0) {
      // Pop the max element off
      Storage maxEl = maxHeap.poll();

      // Append letter to the string
      sb.append(maxEl.letter);

      if (prevElement != null && prevElement.count > 0) maxHeap.add(prevElement);

      prevElement = new Storage(maxEl.count - 1, maxEl.letter);

    }

    return sb.toString();
  }

  public static void main(String[] args) {

    String s = "aaaaabbbbbbb";

    String res = reorganizeString(s);

    System.out.println(res);

  }
}
