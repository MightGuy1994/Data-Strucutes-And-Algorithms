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
class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null) {return t2;}
        if(t2 == null) {return t1;}


        t1.val += t2.val;

        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);

        return t1;
    }
}

// classic recursion logic. if either of tree is null, return other. add value of tree2 to tree1. then add t1.left, t2.left by
// passing nodes to same function. return t1.

// time complexity : O(m) minimum nodes of the two trees.
// space complexity: O(logm). depth of tree.