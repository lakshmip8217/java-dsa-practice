package trees;

import java.util.*;

public class DFSTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.print("Preorder: ");
        preorder(root);

        System.out.print("\nInorder: ");
        inorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val); // Root
        preorder(root.left);          // Left
        preorder(root.right);         // Right
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);           // Left
        System.out.println(root.val); // Root
        inorder(root.right);          // Right
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);         // Left
        postorder(root.right);        // Right
        System.out.println(root.val); // Root
    }

    /**
     * Time - O(n)
     * Space - O(h) for a balanced/skewed binary tree traversal pattern,
     * O(n) worst case for the explicit stack depending on tree shape
     * @param root
     * @return
     */
    public List<Integer> dfsIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();

        nodes.push(root);
        depths.push(1);

        int maxDepth = 0;

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            int depth = depths.pop();

            maxDepth = Math.max(maxDepth, depth);

            if (current.right != null) {
                nodes.push(current.right);
                depths.push(depth + 1);
            }

            if (current.left != null) {
                nodes.push(current.left);
                depths.push(depth + 1);
            }
        }

        return maxDepth;
    }

    static int maxDepthStack(TreeNode root) {
        int maxDepth = 0;
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);

        while(!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentDepth = depthStack.pop();
            maxDepth = Math.max(maxDepth, currentDepth);

            if(currentNode.right != null) {
                nodeStack.push(currentNode.right);
                depthStack.push(currentDepth + 1);
            }
            if(currentNode.left !=null) {
                nodeStack.push(currentNode.left);
                depthStack.push(currentDepth+1);
            }
        }
        return maxDepth;
    }
}
