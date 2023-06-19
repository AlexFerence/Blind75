package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestBinaryTree {

  // Consider two approaches

  // 1. Add all elements into the list

  // 2. take advantage of the BST structure?

  public static int kthSmallestElement(BinaryTreeNode root, int k) {

    // Navigate the bst
    List<Integer> arr = new ArrayList<>();
    recursiveTraversal(root, arr);

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

    for (int a : arr) {
      if (maxHeap.size() < k) maxHeap.add(a);
      else if (maxHeap.size() > 0 && a < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(a);
      }
    }

    return maxHeap.peek();
  }

  public static void recursiveTraversal(BinaryTreeNode node, List<Integer> arr) {
    if (node == null) return;
    arr.add(node.data);
    recursiveTraversal(node.left, arr);
    recursiveTraversal(node.right, arr);
  }

}
