package org.luo.arithmetic.leetcode.treenode;

/**
 * 这题主要是要想明白。"以小见大"
 * 如果a,b,c为整个树的一部分
 *
 *          a
 *        /   \
 *      b      c
 *
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
}
