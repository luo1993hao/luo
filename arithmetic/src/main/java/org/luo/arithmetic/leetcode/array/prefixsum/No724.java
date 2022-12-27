package org.luo.arithmetic.leetcode.array.prefixsum;

public class No724 {


    public static int pivotIndex(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int[] prefixNum = getPrefixNum(nums);
        int max = prefixNum[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && 0 == max - prefixNum[0]) {
                return 0;
            }

            if (i > 0 && prefixNum[i - 1] == max - prefixNum[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getPrefixNum(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int i = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }

}
