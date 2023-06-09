package LinkedLists;

public class ReverseLinkedList {

  public static LinkedListNode reverse(LinkedListNode head) {

    LinkedListNode prev = null;
    LinkedListNode current = head;

    while (current.next != null) {
      // Store the next node for reference
      LinkedListNode tempNext = current.next;

      // Reverse the next node of current node
      current.next = prev;

      // Increment the node to the next one
      prev = current;
      current = tempNext;
    }
    current.next = prev;
    return current;
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
