/**
 * No.230 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class No230 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left, k);
        if (leftCount + 1 == k) {
            return root.val;
        } else if(k <= leftCount) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        return count(root.left, k) + count(root.right, k) + 1;
    }
}
