package fastslowpointers;

public class MiddleLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast == null) {
        break;
      }
      fast = fast.next;
    }
    return slow;
  }

  public static void main(String[] args) {

  }

}
