package org.luo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class YangHuiSanJiao {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> C = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

}
