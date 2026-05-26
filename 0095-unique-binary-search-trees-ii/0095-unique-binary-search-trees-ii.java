/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0)
            return new ArrayList<>();

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // base case
        if (start > end) {

            result.add(null);
            return result;
        }

        // try every node as root
        for (int root = start; root <= end; root++) {

            // generate all left subtrees
            List<TreeNode> leftTrees =
                generate(start, root - 1);

            // generate all right subtrees
            List<TreeNode> rightTrees =
                generate(root + 1, end);

            // combine left and right
            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);

                    node.left = left;
                    node.right = right;

                    result.add(node);
                }
            }
        }

        return result;
    }
}