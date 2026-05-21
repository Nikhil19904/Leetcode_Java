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
    public int minDepth(TreeNode root) {

        // base case
        if(root==null){
            return 0;
        }
        // if left subtree is fully missing
        if(root.left==null){
            return minDepth(root.right)+1;
        }

        // if right Subtree is fully missing
        if(root.right==null){
            return minDepth(root.left)+1;
        }

        // if all subtree is exist
        int minDepth=Math.min( minDepth(root.left),minDepth(root.right))+1;
        return minDepth;
        
    }
}