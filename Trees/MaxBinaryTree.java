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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int l, int h) {
        if(l == h)
            return null;

        int max_i  = maxValue(nums,l,h);
        TreeNode node = new TreeNode(nums[max_i]);
        node.left = constructMaximumBinaryTree(nums,l,max_i);
        node.right = constructMaximumBinaryTree(nums,max_i+1,h);
        return node;
    }

    public int maxValue(int[] nums,int l, int h) {
        int position = l;
        for(int i = l+1; i< h; i++) {
            if(nums[i] > nums[position]) {
                position = i;
            }
        }
        return position;
    }
}

// time complexity : O(n2)
// space Compleixity : O(n)
// use simple recursive logic and divide array based on the highest index;