package backtracking;

public class HouseRobber3 {

  public static int rob(TreeNode<Integer> root) {
    return robRec(root, false);
  }

  public static int robRec(TreeNode<Integer> node, boolean prevRob) {
    if (node == null) return 0;
    int robThisNodeRes = 0;
    if (!prevRob) {
      // Rob this node and not the neighbours
      robThisNodeRes = node.data + robRec(node.right, true) + robRec(node.left, true);
    }
    // Rob just the right node
    int dontRobRes = robRec(node.right, false) + robRec(node.left, false);
    return Math.max(robThisNodeRes, dontRobRes);
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(3);
    root.left = new TreeNode<>(5);
    root.right = new TreeNode<>(25);
    root.left.left = new TreeNode<>(10);
    root.left.right = new TreeNode<>(12);
    root.right.left = new TreeNode<>(3);
    root.right.right = new TreeNode<>(1);

    int res = rob(root);
    System.out.println(res);
  }
}
