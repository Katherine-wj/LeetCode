/**
 * No.117 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class No117 {
    public Node1 connect(Node1 root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findToLinked(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = findToLinked(root.next);
        }
        return root;
    }

    private Node1 findToLinked(Node1 root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        return findToLinked(root.next);
    }
}
