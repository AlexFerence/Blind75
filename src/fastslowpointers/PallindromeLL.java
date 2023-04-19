package fastslowpointers;

import java.util.List;
import java.util.Stack;

public class PallindromeLL {
  public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) fast = fast.next;
      else break;
    }

    // ListNode.print(head);
    // create a new linked list reversed from the slow pointer
    if (slow == null) return false;
    ListNode reversed = reversedList(slow);
    // ListNode.print(reversed);
    while (reversed != null && head != null) {
      if (reversed.val != head.val) {
        return false;
      }
      // increment pointer
      reversed = reversed.next;
      head = head.next;
    }
    return true;

  }

  public static ListNode reversedList(ListNode slowPtr) {
    ListNode reverse = null;
    while (slowPtr != null) {
      ListNode next = slowPtr.next;
      slowPtr.next = reverse;
      reverse = slowPtr;
      slowPtr = next;
    }
    return reverse;
  }

  public static void main(String[] args) {
    ListNode head =
        new ListNode(1,
            new ListNode(2,
                new ListNode(2,
                    new ListNode(1)
                )
            )
        );

    System.out.println(isPalindrome(head));
  }
}
