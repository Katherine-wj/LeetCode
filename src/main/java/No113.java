import java.util.ArrayList;
import java.util.List;

/**
 * No.113 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class No113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            list.add(root.val);
            res.add(list);
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        helper(root.left, sum);
        list.remove(list.size() - 1);
        list.add(root.val);
        helper(root.right, sum);
        list.remove(list.size() - 1);
    }

}
