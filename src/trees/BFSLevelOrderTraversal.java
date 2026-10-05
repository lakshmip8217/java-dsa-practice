package trees;

import java.util.*;

public class BFSLevelOrderTraversal {

    void main() {
       TreeNode root = new TreeNode(3);
       root.left = new TreeNode(9);
       root.right = new TreeNode(20);
       root.right.left = new TreeNode(15);
       root.right.right = new TreeNode(7);
       IO.println(maxDepth(root));
       IO.println(maxDepthIterative(root));
       //IO.println(maxDepthStack(root));
    }

    /**
     * Time Complexity: \(\mathcal{O}(N)\) because the algorithm
     * must visit every node exactly once to determine the maximum depth.
     * Space Complexity: \(\mathcal{O}(H)\) where H is the height of the tree.
     * This space is utilized by the internal call stack during recursion.
     * In the worst case (a completely skewed tree resembling a linked list),
     * the space complexity becomes \(\mathcal{O}(N)\)
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Return the larger depth plus 1 for the current node
        return Math.max(left, right) + 1;
    }

    /**
     * Time Complexity: \(\mathcal{O}(N)\) because every node in the tree is added and removed from the queue exactly once.
     * Space Complexity: \(\mathcal{O}(W)\) where W is the maximum width of the binary tree.
     * In the worst-case scenario (a complete binary tree),
     * the bottom level holds up to N/2 nodes, making the space complexity \(\mathcal{O}(N)\)
     * @param root
     * @return
     */
    static int maxDepthIterative(TreeNode root) {
        int depth = 0;

        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size(); // Number of nodes at current level

            // Process all nodes of the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();

                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }

            // Increment depth after finishing a full level
            depth++;
        }
        return depth;
    }

    /**
     * Time - O(nodes)
     * Space - O(width)
     * @param root
     * @return
     */
    static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
