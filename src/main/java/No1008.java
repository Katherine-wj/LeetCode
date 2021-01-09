/**
 * No.1008 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 *
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 */
public class No1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return bstDfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstDfs(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        for (; index < end; index++) {
            if (preorder[index] > root.val) {
                break;
            }
        }
        root.left = bstDfs(preorder, start + 1, index - 1);
        root.right = bstDfs(preorder, index, end);
        return root;
    }
}
