package org.luo.arithmetic.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        //k:value .v:index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
