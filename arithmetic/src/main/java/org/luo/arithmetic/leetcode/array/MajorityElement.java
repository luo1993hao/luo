package org.luo.arithmetic.leetcode.array;

import java.util.Arrays;

/**
 * easy #169
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
