package org.luo.arithmetic.leetcode.array;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[nums1.length - m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
