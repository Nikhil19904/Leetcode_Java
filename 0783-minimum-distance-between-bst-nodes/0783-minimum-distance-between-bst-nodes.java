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
    public int minDiffInBST(TreeNode root) 
    {
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);

        int minValue=Integer.MAX_VALUE;
        for(int i=1;i<ans.size();i++)
        {
            minValue=Math.min(ans.get(i)-ans.get(i-1),minValue);
        }  
        return minValue; 
    }

    private void inorder(TreeNode root,List<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}