package org.luo.arithmetic.sort;

/**
 * 选择排序
 * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
 * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 *
 * @author luohaoyu
 * @since 2019-01-10 21:01
 **/
public class ChooseSort extends Sort<Integer> {
    /**
     * 核心思想就是每次循环用index记录最小值的下标
     */
    @Override
    public void sort(Integer[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[i], nums[j])) {
                    index = j;
                }
                swap(nums, index, i);
            }
        }
    }
}
