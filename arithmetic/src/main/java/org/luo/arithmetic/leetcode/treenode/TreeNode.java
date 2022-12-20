package org.luo.arithmetic.leetcode.treenode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int pathSum(TreeNode root, int targetSum) {
        int result;
        result = rootSum(root, (long) targetSum);
        result = result + pathSum(root.left, targetSum);
        result = result + pathSum(root.right, targetSum);
        return result;
    }

    private int rootSum(TreeNode root, Long targetSum) {
        int result = 0;
       if (root==null){
           return 0;
       }
       if (root.val ==targetSum){
           result++;
       }
       result = result+rootSum(root.right,targetSum-root.val);
       result = result+rootSum(root.left,targetSum-root.val);
       return result;
    }
}