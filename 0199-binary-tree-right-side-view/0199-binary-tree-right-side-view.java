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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list=new ArrayList<>();

        // base case
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                TreeNode current=queue.poll();

                // last node of level
                if(i==size-1){
                    list.add(current.val);
                }

                if(current.left!=null){
                    queue.offer(current.left);
                }

                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
        }
        return list;
    }
}

// Time : O(n).....S:O(n)