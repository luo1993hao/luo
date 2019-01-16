package org.luo.arithmetic.sort;

/**
 * 插入排序
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序
 *
 * @author luohaoyu
 * @since 2019-01-15 21:25
 **/
public class InsertionSort extends Sort<Integer> {

    @Override
    public void sort(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                }

            }

        }
    }
}
