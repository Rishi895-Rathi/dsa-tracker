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
    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        dfs(root, 1, 0);

        return maxLen;
    }

    private void dfs(TreeNode node, int dir, int len){
        if(node == null) return;

        maxLen = Math.max(maxLen, len);

        if(dir == 0){
            dfs(node.left, 1, len + 1);
            dfs(node.right, 0, 1);
        }else{
            dfs(node.right, 0, len + 1);
            dfs(node.left, 1, 1);
        }
    }
}