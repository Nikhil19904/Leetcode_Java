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
    public TreeNode invertTree(TreeNode root) {

        // base case 
        if(root==null){
            return null;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            TreeNode current=q.poll();

            // swap childern 
            TreeNode temp=current.left;
            current.left=current.right;
            current.right=temp;

            // add left child
            if(current.left!=null){
                q.offer(current.left);
            }

            // add right child
            if(current.right!=null){
                q.offer(current.right);
            }
        }

        return root;
    }
}


// Time : O(n)........S:O(n)