/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeastCommonAncestor {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isNodePresent(root,p,q);
        return this.ans;
    }
    boolean isNodePresent(TreeNode root, TreeNode p,TreeNode q){
        if(root == null)
            return false;

        int lp = isNodePresent(root.left,p,q)? 1:0;
        int rp = isNodePresent(root.right,p,q)? 1:0;
        int mid = ((root == p) || (root == q)) ? 1:0;
        if(lp+rp+mid >=2) {
            this.ans = root;
        }
        return (lp+rp+mid >0);
    }
}
//common tree traversal. search for a node, if present return true; and when left+right+mid >=2 then its LCA
//time complexity : O(n)
// Space Complexity : O(h) where h is the depth of tree.