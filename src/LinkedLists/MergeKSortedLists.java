package LinkedLists;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

  private static class Storage {
    LinkedListNode node;
    int index;
    public Storage(LinkedListNode n, int i) {
      this.node = n;
      this.index = i;
    }
  }

  public static LinkedListNode mergeKLists(List<LinkedList> lists) {
    PriorityQueue<Storage> minHeap = new PriorityQueue<>((a, b) -> a.node.data - b.node.data);

    // Add the first element of each linked list to the heap
    for (int i = 0; i < lists.size(); i++) {
      LinkedList ll = lists.get(i);
      minHeap.add(new Storage(ll.head, i));
      ll.head = ll.head.next;
    }

    LinkedList mergedLL = new LinkedList();
    LinkedListNode current = null;

    while (minHeap.size() > 0) {
      // Add the min to the ll
      Storage minEl = minHeap.poll();
      if (current == null) {
        mergedLL.head = minEl.node;
        current = minEl.node;
      }
      else {
        current.next = minEl.node;
        current = minEl.node;
      }

      // Fill in the min heap
      LinkedList tempLL = lists.get(minEl.index);
      if (tempLL.head != null) {
        minHeap.add(new Storage(tempLL.head, minEl.index));
        tempLL.head = tempLL.head.next;
      }
    }

    return mergedLL.head;
  }

  public static void main(String[] args) {
    int[] nodes = {1, 6, 9, 10};
    LinkedList<Integer> LL1 = new LinkedList<>();
    LL1.createLinkedList(nodes);
    LL1.printLinkedList();

    int[] nodes2 = {3, 7, 8, 11, 12};
    LinkedList<Integer> LL2 = new LinkedList<>();
    LL2.createLinkedList(nodes2);
    LL2.printLinkedList();

    int[] nodes3 = {4,5};
    LinkedList<Integer> LL3 = new LinkedList<>();
    LL3.createLinkedList(nodes3);
    LL3.printLinkedList();

    LinkedListNode res = mergeKLists(List.of(LL1));
    LinkedList.printLinkedList(res);
  }

}
