package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    Set<Integer> vals = new HashSet<>();
    while (head.next != null) {
      if (vals.contains(head.val)) {
        return true;
      }
      vals.add(head.val);
      head = head.next;
    }
    return false;
  }
}
