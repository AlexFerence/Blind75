package LinkedLists;

import javax.sound.sampled.Line;

public class ReverseKGroup {

  public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {

    LinkedListNode pioneer = head;
    LinkedListNode prevGroupEnd = null;
    LinkedListNode current = head;
    LinkedListNode newHead = null;

    while (pioneer != null) {

      // Pioneer ahead
      int pioneerCount = 0;
      while (pioneer != null && pioneerCount < k - 1) {
        pioneer = pioneer.next;
        pioneerCount++;
      }
      if (pioneer == null) break;

      LinkedListNode startOfNextGroup = pioneer.next;

      // Keep track of initial first node
      LinkedListNode groupInitialStart = current;
      LinkedListNode prev = null;

      while (current != pioneer) {
        LinkedListNode tempNext = current.next;
        current.next = prev;
        prev = current;
        current = tempNext;
      }
      current.next = prev;

      groupInitialStart.next = startOfNextGroup;

      if (prevGroupEnd != null) {
        prevGroupEnd.next = current;
      }
      prevGroupEnd = groupInitialStart;
      // Check if this is the first group and set return value
      if (newHead == null) newHead = current;
      // Increment to next group phase
      current = startOfNextGroup;
      pioneer = startOfNextGroup;
    }

    return newHead;
  }

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
    int[] nodes = {1,2,3,4,5,6,7,8,9};
    LinkedList<Integer> LL = new LinkedList<>();
    LL.createLinkedList(nodes);
    LL.printLinkedList();
    LinkedListNode res = reverseKGroups(LL.head, 3);
    LinkedList.printLinkedList(res);
  }
}
