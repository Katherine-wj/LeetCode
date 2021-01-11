import java.util.HashMap;
import java.util.Map;

/**
 * No.437 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class No437 {
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        map.put(0, 1);
        return helper(root, sum, 0);
    }

    private int helper(TreeNode root, int sum, int cur) {
        int res = 0;
        if (root == null) {
            return res;
        }
        cur = cur + root.val;
        res += map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res = res + helper(root.left, sum, cur) + helper(root.right, sum, cur);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return res;
    }
}
