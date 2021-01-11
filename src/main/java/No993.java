/**
 * No.993 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 */
public class No993 {
    int depth = -1;
    TreeNode parent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        return helper(root, x, y, 0, null);
    }

    private boolean helper(TreeNode root, int x, int y, int d, TreeNode p) {
        if(root == null) {
            return false;
        }
        if ((x == root.val || y == root.val) && d == depth && p != parent) {
            return true;
        }
        if(x == root.val || y == root.val) {
            depth = d;
            parent = p;
        }
        return helper(root.left, x, y, d + 1, root) || helper(root.right, x, y, d + 1, root);
    }
}
