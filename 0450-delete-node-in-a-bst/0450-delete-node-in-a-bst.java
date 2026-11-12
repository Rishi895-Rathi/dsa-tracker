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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            return delete(root);
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.left != null){
                if(curr.left.val == key){
                    curr.left = delete(curr.left);
                    return root;
                }
                q.offer(curr.left);
            }
            if(curr.right != null){
                if(curr.right.val == key){
                    curr.right = delete(curr.right);
                    return root;
                }
                q.offer(curr.right);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode node){
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        TreeNode successor = node.right;
        while(successor.left != null){
            successor = successor.left;
        }
        successor.left = node.left;
        return node.right;
    }
}