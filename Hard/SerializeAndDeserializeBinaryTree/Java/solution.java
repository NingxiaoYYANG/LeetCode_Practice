/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        buildString(root, res);
        return String.join(",", res);
    }
    
    private void buildString(TreeNode node, List<String> res)   {
        if (node == null) {
            res.add("N");
        } else {
            res.add(String.valueOf (node.val));
            buildString(node.left, res);
            buildString(node.right, res);
        }
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        index = 0;
        return buildTree(nodeValues);
    }

    private int index;
    private TreeNode buildTree(String[] nodeValues) {
        if (nodeValues[index].equals("N")) {
            index++;
            return null;
        
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[index]));
        index++;
        node.left = buildTree(nodeValues);
        node.right = buildTree(nodeValues);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));