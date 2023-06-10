package LinkedLists;

public class ReverseLL2 {

  public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

    LinkedListNode current = head;
    LinkedListNode prev = null;

    LinkedListNode beforeLeftNode = null;
    LinkedListNode leftNode = null;

    LinkedListNode afterRightNode = null;
    LinkedListNode rightNode = null;

    int currentIndex = 1;

    while (current.next != null) {

      if (currentIndex == left) {
        beforeLeftNode = prev;
        leftNode = current;
      }

      if (currentIndex > left && currentIndex <= right) {
        LinkedListNode tempNext = current.next;
        current.next = prev;
        prev = current;
        current = tempNext;
        currentIndex++;
      }
      else {
        currentIndex++;
        prev = current;
        current = current.next;
      }

      if (currentIndex == right) {
        rightNode = current;
        afterRightNode = current.next;
        if (left == 1) head = current;
      }
      if (currentIndex == right && beforeLeftNode != null) {
        beforeLeftNode.next = rightNode;
      }
      if (currentIndex == right && leftNode != null) {
        leftNode.next = afterRightNode;
      }
      if (currentIndex == right && afterRightNode == null) {
        head.next = prev;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = reverseBetween(LL.head,1, 9);
    LinkedList.printLinkedList(res);
  }
}
