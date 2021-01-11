/**
 * No.938 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class No938 {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return res;
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        if (root.val < low) {
            rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
        return res;
    }
}
