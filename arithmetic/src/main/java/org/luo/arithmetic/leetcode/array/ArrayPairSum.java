package org.luo.arithmetic.leetcode.array;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length; i += 2) {
            total = nums[i] + total;

        }
        return total;
    }
}
