package fastslowpointers;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
  ListNode(int x, ListNode next) {
    val = x;
    this.next = next;
  }

  public static void print(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " ");
      curr = curr.next;
    }
    System.out.println();
  }
 }