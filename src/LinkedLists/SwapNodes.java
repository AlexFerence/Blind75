package LinkedLists;

public class SwapNodes {
  public static LinkedListNode swapNodes(LinkedListNode head, int k) {
    // Find first element
    LinkedListNode curr = head;
    LinkedListNode currPrev = null;
    int count = 1;

    while (count < k) {
      currPrev = curr;
      curr = curr.next;
      count++;
    }

    LinkedListNode front = curr;
    LinkedListNode frontPrev = currPrev;

    LinkedListNode end = head;
    LinkedListNode endPrev = null;
    while (curr.next != null) {
      endPrev = end;
      curr = curr.next;
      end = end.next;
    }

    LinkedListNode tempEndNext = end.next;

    if (endPrev == null) {
      head = front;
    }
    else {
      endPrev.next = front;
    }
    end.next = front.next;

    if (frontPrev == null) {
      head = end;
    }
    else {
      frontPrev.next = end;
    }
    front.next = tempEndNext;

    // Find second element

    // Write your code here
    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1, 2, 3, 4, 5};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = swapNodes(LL.head,3);
    LinkedList.printLinkedList(res);
  }
}
