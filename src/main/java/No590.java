import java.util.ArrayList;
import java.util.List;

/**
 * No.590N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */

public class No590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        for (Node child : root.children) {
            result.addAll(postorder(child));
        }
        result.add(root.val);
        return result;
    }
}
