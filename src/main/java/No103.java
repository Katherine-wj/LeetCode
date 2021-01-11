import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No.103 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class No103 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return res;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        helper(nodes, 1);
        return res;
    }

    private void helper(List<TreeNode> nodes, int level) {
        if(nodes.size() == 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        List<TreeNode> moreNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            list.add(node.val);
            if(node.left != null) {
                moreNodes.add(node);
            }
            if(node.right != null) {
                moreNodes.add(node);
            }
        }
        if (level % 2 == 0) {
            Collections.reverse(list);
        }
        res.add(list);
        helper(moreNodes, level + 1);
    }
}
