package org.luo.arithmetic.leetcode;

/**
 * 背包算法
 * <p>
 * 背包算法的介绍
 * 参考：
 * https://www.cnblogs.com/toone/p/8554817.html
 * <p>
 *
 *
 * @author luohaoyu
 * @since 2019-01-21 22:40
 **/
public class PackageArithmetic {
    private static int findMaxValue(int w, int n, int[] weight, int[] value) {
        int[][] max = new int[n + 1][w + 1];
        //M[n,W]
        for (int i = 0; i <= w; i++) {
            max[0][i] = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= w; k++) {
                    //第j个物品对应重量的下标减1，从0开始。
                    if (weight[j - 1] > k) {
                        //当加入的一个物品重量大于k，这个物品一定不能选
                        max[j][k] = max[j - 1][k];
                    } else {
                        //不选第j个物品
                        int a = max[j - 1][k];
                        //可以选第j个物品，选择这个物品
                        int b = value[j - 1] + max[j - 1][k - weight[j - 1]];
                        //可以选第j个物品，选择这个物品
                        max[j][k] = a > b ? a : b;
                    }
                }
            }
        }

        //遍历数组结果，打印出来看看
        for (int[] is : max) {
            for (int i : is) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        return max[n][w];
    }

    public static void main(String[] args) {
        //背包装入的总重量不能超过该值，使得总价值最大
        int w = 11;
        //五个物品
        int n = 5;
        //对应物品的价值
        int[] value = {1, 6, 18, 22, 28};
        //对应每个品的重量
        int[] weight = {1, 2, 5, 6, 7};
        System.out.println("所得结果：" + findMaxValue(w, n, weight, value));
    }
}
