/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(values));
        return buildTree(queue);
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null").append(",");
        }
        else {
            sb.append(root.val).append(",");
            buildString(root.left,sb);
            buildString(root.right,sb);
        }

    }

    public TreeNode  buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if(val.equals("null")) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// use preorder to serialize the tree. if encouter null replace with null. and append "," everywhere.
// during deserailze use queue. same logic. it will use same logic of preorder. takes the root first and then left,right