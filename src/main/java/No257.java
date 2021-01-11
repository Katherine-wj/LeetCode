import java.util.ArrayList;
import java.util.List;

/**
 * No.257 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class No257 {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return res;
        }
        dfs(root);
        generateResult(paths);
        return res;
    }

    private void generateResult(List<List<Integer>> paths) {
        if (paths.size() == 0) {
            return;
        }
        for (int i = 0; i < paths.size(); i++) {
            List<Integer> currPath = paths.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < currPath.size(); j++) {
                Integer currVal = currPath.get(j);
                sb.append(currVal);
                if (j != currPath.size() - 1) {
                    sb.append("->");
                }
            }
            res.add(sb.toString());
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<Integer>(path));
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        path.remove(path.size() - 1);
    }
}
