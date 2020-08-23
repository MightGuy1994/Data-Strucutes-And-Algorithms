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
class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfTree(root);
        return diameter;
    }
    int heightOfTree(TreeNode root){
        if(root == null)
            return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        diameter = Math.max(diameter,lh+rh);
        return Math.max(lh,rh)+1;
    }
}

//time complexity : O(n) where n is the number of nodes.
//space complexity : O(h) where h is the max depth of binary tree.