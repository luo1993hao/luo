package org.luo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }
        if (result.size() < 3) {
            return result.get(result.size() - 1);
        }
        return result.get(result.size() - 3);
    }
}
