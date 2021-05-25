package org.luo.arithmetic.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
