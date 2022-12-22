package org.luo.arithmetic.leetcode.treenode;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class No112 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 112
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    /**
     * 113题
     */
    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }

    /**
     * 257题
     *
     * @param root
     * @return
     */

    List<String> res = new ArrayList<>();
    List<String> pa = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs1(root);
        return res;
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        pa.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            StringBuilder pc = new StringBuilder();
            for (int i = 0; i < pa.size(); i++) {
                if (i == 0) {
                    pc = new StringBuilder(pa.get(i));
                } else {
                    pc.append("->").append(pa.get(i));
                }
            }
            res.add(pc.toString());
        }
        dfs1(root.right);
        dfs1(root.left);
        pa.remove(pa.size() - 1);

    }



}
