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
class MaxPathSum {
    private Integer maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDepthSum(root);
        return maxSum;

    }
    int maxDepthSum(TreeNode root){
        if(root == null)
            return 0;
        int lsum = maxDepthSum(root.left);
        int rsum = maxDepthSum(root.right);
        if(lsum < 0) {lsum = 0;}
        if(rsum < 0) {rsum = 0;}

        maxSum = Math.max(maxSum,root.val+lsum+rsum);
        return Math.max(lsum,rsum)+root.val;
    }
}
//similar to diameter but return +root.val instead of 1. Also calculate maxSum like diameter. One thing to remember, if anypoint sum <0, sum =0;
// time complexity : O(n)
// Space Complexity : O(h) where h is the max depth.