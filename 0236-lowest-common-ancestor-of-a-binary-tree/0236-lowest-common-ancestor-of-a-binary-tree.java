/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if(root==null || root==p || root==q){
            return root;
        }

        // search left subtree
        TreeNode left=lowestCommonAncestor(root.left,p,q);

        // search right subtree
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        // both found
        if(left!=null && right!=null){
            return root;
        }

        // only one side found
        if(left!=null){
            return left;
        }
        return right;


        
    }
}