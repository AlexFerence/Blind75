package LinkedLists;

public class ReorderLL {
  public static LinkedListNode reorderList(LinkedListNode head) {
    // Find middle node
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    LinkedListNode prevSlow = null;

    while (fast != null) {
      prevSlow = slow;
      slow = slow.next;
      fast = fast.next;
      if (fast != null) fast = fast.next;
    }

    // Cut off the forward list
    prevSlow.next = null;

    // Reverse second half
    LinkedListNode prev = null;
    while (slow != null) {
      LinkedListNode tempNext = slow.next;
      slow.next = prev;
      prev = slow;
      slow = tempNext;
    }

    // Merge the two lists
    // prev is the reversed list

    LinkedListNode merged = head;
    LinkedListNode reversed = prev;

    while (merged != null && reversed != null) {

      LinkedListNode nextForward = merged.next;
      LinkedListNode nextReversed = reversed.next;

      merged.next = reversed;
      reversed.next = nextForward;

      merged = nextForward;
      reversed = nextReversed;
    }

    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1, 2, 3, 4};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();

    LinkedListNode res = reorderList(LL.head);
    LinkedList.printLinkedList(res);
  }
}
