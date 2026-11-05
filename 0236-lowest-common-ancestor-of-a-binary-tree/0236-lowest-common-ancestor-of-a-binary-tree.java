/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<TreeNode> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findSet(root, p);
        findList(root, q);

        for(int i = list.size() - 1; i >= 0; i--){
            if(set.contains(list.get(i))){
                return list.get(i);
            }
        }

        return null;
    }

    boolean findSet(TreeNode root, TreeNode target){
        if(root == null) return false;

        set.add(root);

        if(root == target) return true;

        if(findSet(root.left, target) || findSet(root.right, target)){
            return true;
        }

        set.remove(root);
        return false;
    }

    boolean findList(TreeNode root, TreeNode target){
        if(root == null) return false;

        list.add(root);

        if(root == target) return true;

        if(findList(root.left, target) || findList(root.right, target)){
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }
}