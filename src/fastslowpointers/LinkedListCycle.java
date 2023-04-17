package fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head.next == null) return false;
    ListNode fast = head.next;
    ListNode slow = head;

    while (fast != null && fast != slow) {
      fast = fast.next;
      if (fast == null) {
        break;
      }
      fast = fast.next;

      slow = slow.next;
    }

    return fast == slow;
  }
}
