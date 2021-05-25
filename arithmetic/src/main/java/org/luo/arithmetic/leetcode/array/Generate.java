package org.luo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nowResult = new ArrayList<>();
            for (int i1 = 0; i1 <= i; i1++) {
                if (i1 == 0 || i1 == i) {
                    nowResult.add(1);
                } else {
                    nowResult.add(result.get(i - 1).get(i1 - 1) + result.get(i - 1).get(i1));
                }
            }
            result.add(nowResult);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
