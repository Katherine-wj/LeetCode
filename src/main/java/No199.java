import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.199 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> levelResult = levelOrder(root);
        int size = levelResult.size();
        for(int i = 0; i < size; i++) {
            List<Integer> level = levelResult.get(i);
            result.add(level.get(level.size() - 1));
        }
        return result;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelResult = new ArrayList<List<Integer>>();
        if(root == null) {
            return levelResult;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelResult.add(level);
        }
        return levelResult;
    }
}
