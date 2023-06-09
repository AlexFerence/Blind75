package LinkedLists;

public class ReverseLinkedList {

  public static LinkedListNode reverse(LinkedListNode head) {

    LinkedListNode prev = null;

    while (head.next != null) {
      // Store the next node for reference
      LinkedListNode tempNext = head.next;

      // Reverse the next node of current node
      head.next = prev;

      // Increment the node to the next one
      prev = head;
      head = tempNext;
    }
    head.next = prev;
    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1,5,3,4};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode reversedLL = reverse(LL.head);
    LinkedList.printLinkedList(reversedLL);
  }
}
