package org.luo.arithmetic.leetcode.treenode;

/**
 * 下面三个题都是一个模版的题目
 * 关键词:二叉树，dfs,非根节点。
 * <p>
 * 主要是要想明白。"以小见大"
 * 如果a,b,c为整个树的一部分
 * <p>
 * a
 * /   \
 * b      c
 * <p>
 * 这题的结果 要么为
 * 1.a+b+c
 * 2.为a+b+a的父节点
 * 3.a+c+a的父节点
 * 所以代码流程应该是当节点到a的时候。
 * 向左节点b递归 算出左边最大值（b下面还有节点）  leftMax
 * 向右节点c递归 算出右边最大值（c下面还有节点）   rightMax
 * 对于情况1 此时3个值（a.val+b递归结果+c递归结果）相加
 * 对于情况2和3 此时abc的作用就是给父级提供值。但由于不能重复，
 * 所以abc能给上级提供的值就为a.val+max(leftMax,rightMax)
 */
public class No124 {
    //初始化为int最小值的原因是无论上述情况的1。2。3 都绕不开a这个节点。如果a为负数，也需要加上。
    //为了保证初始化值比a小 所以为int最小值
    Integer result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        result = Math.max(result, left + root.val + right);
        return root.val + Math.max(left, right);
    }

    /**
     * 687
     *
     * @param root
     * @return
     */
    private Integer res = 0;

    public int longestUnivaluePath(TreeNode root) {
        this.dfs1(root);
        return res;
    }

    public int dfs1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs1(node.left);
        int right = dfs1(node.right);
        int nowLeft = 0;
        int nowRight = 0;
        if (node.left != null && node.val == node.left.val) {
            nowLeft = left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            nowRight = right + 1;
        }
        res = Math.max(res, nowLeft + nowRight);
        return Math.max(nowLeft, nowRight);
    }


    /**
     * 543
     *
     * @param root
     * @return
     */
    int result1 = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs2(root);
        return result1;
    }

    public int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs2(root.left);
        int right = dfs2(root.right);
        int nowLeft = 0;
        int nowRight = 0;
        if (root.right != null) {
            nowRight = right + 1;
        }
        if (root.left != null) {
            nowLeft = left + 1;
        }
        result1 = Math.max(result1, nowRight + nowLeft);
        return Math.max(nowLeft, nowRight);
    }
}
