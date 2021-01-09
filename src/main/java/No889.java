/**
 * No.889 根据前序和后序遍历构造二叉树
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * pre 和 post 遍历中的值是不同的正整数。
 */
public class No889 {
    int[] pre, post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return make(0, 0, pre.length);
    }

    private TreeNode make(int i0, int i1, int n) {
        if (n <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[i0]);
        if (n == 1) {
            return root;
        }
        int l = 1;
        for (; l < n; l++) {
            if (pre[i0 + 1] == post[i1 + l - 1]) {
                break;
            }
        }
        root.left = make(i0 + 1, i1, l);
        root.right = make(i0 + l + 1, i1 + l, n - l - 1);
        return root;
    }
}
