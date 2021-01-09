import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.366 寻找二叉树的叶子节点
 * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
 * 1.依次从左到右，每次收集并删除所有的叶子节点
 * 2.重复如上过程直到整棵树为空
 */

public class No366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int maxHeight = dfs(root, hash);
        for (int i = 0; i < maxHeight; i++) {
            result.add(hash.get(i));
        }
        return result;
    }

    private int dfs(TreeNode root, Map<Integer, List<Integer>> hash) {

        if(root == null) {
            return 0;
        }
        int height = Math.max(dfs(root.left, hash), dfs(root.right, hash)) + 1;
        hash.putIfAbsent(height, new ArrayList<>());
        hash.get(height).add(root.val);
        return height;
    }
}
