package org.luo.arithmetic.leetcode.dynamicplanning;

public class No53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
