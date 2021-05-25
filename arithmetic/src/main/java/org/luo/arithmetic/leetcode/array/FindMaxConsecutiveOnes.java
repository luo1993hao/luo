package org.luo.arithmetic.leetcode.array;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tempCount = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;
                maxCount = Math.max(tempCount, maxCount);
            } else {
                tempCount = 0;
            }
        }
        return maxCount;
    }
}
