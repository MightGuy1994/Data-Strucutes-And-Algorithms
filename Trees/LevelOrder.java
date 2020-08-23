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
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(root);
        level.add(0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int l = level.poll();
            if(list.size()==l){
                list.add(new ArrayList<>());
            }

            list.get(l).add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                level.add(l+1);
            }
            if(node.right!=null){
                queue.add(node.right);
                level.add(l+1);
            }
        }
        return list;
    }
}

//time complexity : O(N)
//space Complexity : O(N)
// logic: simple BFS. USE QUEUE. Maintain two queues one for level and other for Nodes.