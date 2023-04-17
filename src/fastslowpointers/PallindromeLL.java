package fastslowpointers;

import java.util.Stack;

public class PallindromeLL {
  public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    Stack<Integer> stack = new Stack<>();

    while (fast != null) {

      stack.push(slow.val);

      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }



    return false;
  }
}
