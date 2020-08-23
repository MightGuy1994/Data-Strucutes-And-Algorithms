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
class ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.add(root);
        level.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int l = level.poll();
            if (list.size() == l) {
                list.add(new ArrayList<>());
            }
            list.get(l).add(node.val);
            if (node.right != null) {
                queue.add(node.right);
                level.add(l + 1);
            }
            if (node.left != null) {
                queue.add(node.left);
                level.add(l + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }
}
//Time complexity : O(N)
//Space Complexity : O(N)
// logic: simple level order search and then sort based on the level in list;