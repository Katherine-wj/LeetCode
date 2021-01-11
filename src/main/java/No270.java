import java.util.Map;

/**
 * No.270 最接近的二叉搜索树值
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 */
public class No270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return root.val;
        } else if (root.val > target) {
            if (root.left == null) {
                return root.val;
            }
            int left = closestValue(root.left, target);
            if(Math.abs(root.val - target) < Math.abs(left - target)) {
                return root.val;
            }
            return left;
        } else {
            if (root.right == null) {
                return root.val;
            }
            int right = closestValue(root.right, target);
            if(Math.abs(root.val - target) < Math.abs(right - target)) {
                return root.val;
            }
            return right;
        }
    }
}
