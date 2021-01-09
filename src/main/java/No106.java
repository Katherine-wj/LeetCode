import java.util.HashMap;
import java.util.Map;

/**
 * No.106 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class No106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int poLen = postorder.length;
        if (inLen != poLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(poLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, poLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] postorder, int poLeft, int poRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (poLeft > poRight || inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[poRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTree(postorder, poLeft, pIndex - inLeft + poLeft - 1, map, inLeft, pIndex - 1);
        root.right = buildTree(postorder, pIndex - inLeft + poLeft, poRight, map, pIndex + 1, inRight);
        return root;
    }
}
