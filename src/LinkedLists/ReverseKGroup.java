package LinkedLists;

import javax.sound.sampled.Line;

public class ReverseKGroup {
  public static LinkedListNode reverseKGroupsOLD(LinkedListNode head, int k) {


    // Traverse to see if a valid group is ahead
    LinkedListNode pioneer = head;

    LinkedListNode newHead = null;
    LinkedListNode reverseNode = head;
    LinkedListNode previousPrev = null;

    while (pioneer != null) {

      int pioneerCount = 0;

      while (pioneer != null && pioneerCount < k - 1) {
        pioneer = pioneer.next;
        pioneerCount++;
      }

      // If successful then reverse that group

      LinkedListNode nextPioneer = null;

      LinkedListNode prev = previousPrev;
      if (pioneer != null) {
        prev = pioneer.next;
        nextPioneer = pioneer.next;
      }

      if (pioneer == null) {
        break;
      }

      while (reverseNode != pioneer) {
        LinkedListNode tempNext = reverseNode.next;
        reverseNode.next = prev;
        prev = reverseNode;
        reverseNode = tempNext;
      }
      reverseNode.next = prev;

      if (newHead == null) newHead = reverseNode;
      pioneer = nextPioneer;
      previousPrev = reverseNode;
      reverseNode = nextPioneer;
    }

    return newHead;
  }

  public static void main(String[] args) {
    int[] nodes = {1,2,3,4,5,6};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = reverseKGroups(LL.head, 2);
    LinkedList.printLinkedList(res);
  }
}
