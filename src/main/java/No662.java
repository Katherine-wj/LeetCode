import java.util.ArrayList;
import java.util.List;

/**
 * No.662 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class No662 {

    private List<Integer> ids;
    public int widthOfBinaryTree(TreeNode root) {
        ids = new ArrayList<>();
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int d, int id) {
        if (root == null) {
            return 0;
        }
        if (d == ids.size()) {
            ids.add(id);
        }
        int rootId = id - ids.get(d) + 1;
        return Math.max(rootId, Math.max(dfs(root.left, d + 1, rootId * 2), dfs(root.right, d + 1, rootId * 2 + 1)));
    }
}
