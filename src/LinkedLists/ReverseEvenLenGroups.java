package LinkedLists;

public class ReverseEvenLenGroups {

  public static boolean isEven(int n) {
    return n % 2 == 0;
  }

  public static LinkedListNode reverseList(LinkedListNode head, int size) {

    LinkedListNode prev = null;

    int currentSize = 0;

    while (head != null && currentSize < size) {
      LinkedListNode tempNext = head.next;

      head.next = prev;
    }

    return head;
  }

  public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
    // Write your code here

    int currentGroupSize = 1;

    LinkedListNode current = head;
    LinkedListNode pioneer = head;
    LinkedListNode pioneerPrev = null;

    while (current != null) {
      // Pioneer the group or until the pioneer reaches the end
      int pioneerCount = 1;
      while (pioneer != null && pioneerCount < currentGroupSize) {
        pioneer = pioneer.next;
        pioneerCount++;
      }

      // If it reaches the end of odd group
      if (pioneerCount == currentGroupSize && !isEven(currentGroupSize) && pioneer != null) {
        pioneerPrev = pioneer;
        current = pioneer.next;
        pioneer = pioneer.next;
      }
      // If you reach the end of even size group you need to reverse it
      else if (pioneerCount == currentGroupSize && isEven(currentGroupSize) && pioneer != null) {
        LinkedListNode nodeAfterGroup = pioneer.next;
        LinkedListNode prev = nodeAfterGroup;

        LinkedListNode firstEl = current;

        while (current != pioneer) {
          LinkedListNode tempNext = current.next;
          current.next = prev;
          prev = current;
          current = tempNext;
        }
        current.next = prev;
        if (pioneerPrev != null) {
          pioneerPrev.next = current;
        }

        // Set pioneerPrev
        pioneerPrev = firstEl;

        current = nodeAfterGroup;
        pioneer = nodeAfterGroup;
      }
      // If you have an even group at the end, you also need to reverse
      else if (pioneerCount - 1 < currentGroupSize && isEven(pioneerCount - 1)) {
        LinkedListNode prev = null;
        while (current != pioneer && current != null) {
          LinkedListNode tempNext = current.next;
          current.next = prev;
          prev = current;
          current = tempNext;
        }
        if (pioneerPrev != null) {
          pioneerPrev.next = prev;
        }
      }
      // Else you are at the end
      else {
        break;
      }
      // Increment the group size at the end of the loop
      currentGroupSize++;
    }

    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1,2};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = reverseEvenLengthGroups(LL.head);
    LinkedList.printLinkedList(res);
  }

}
