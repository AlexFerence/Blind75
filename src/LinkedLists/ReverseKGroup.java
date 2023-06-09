package LinkedLists;

public class ReverseKGroup {
  public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {

    while (head != null) {
      // Traverse to see if a valid group is ahead
      LinkedListNode pioneer = head;
      int pioneerCount = 0;

      while (pioneer != null && pioneerCount < k) {
        pioneer = pioneer.next;
        pioneerCount++;
      }

      // If successful then reverse that group
      LinkedListNode groupHead = head;

    }



    return head;
  }

  public static void main(String[] args) {
    int[] nodes = {1,5,3,4};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = reverseKGroups(LL.head, 2);
    LinkedList.printLinkedList(res);
  }
}
