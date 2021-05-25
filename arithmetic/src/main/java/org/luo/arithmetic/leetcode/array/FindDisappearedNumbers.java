package org.luo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static   List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                l.add(i+1);
            }
        }
        return l;
    }


    public static void main(String[] args) {
        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
