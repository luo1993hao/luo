package org.luo.arithmetic.leetcode.array.prefixsum;

public class No238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        //这里可以进行优化。不用使用一个数组保存。
        right[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            right[i] = right[i - 1] * nums[nums.length - i];
        }
        //优化后:
        int rightTotal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = left[i] * rightTotal;
            rightTotal = rightTotal * nums[i];
        }

//        for (int i = 0; i < nums.length; i++) {
//            result[i] = left[i] * right[right.length - i - 1];
//        }


        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(productExceptSelf(ints));
    }
}
