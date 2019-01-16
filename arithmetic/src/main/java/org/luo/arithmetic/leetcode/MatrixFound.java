package org.luo.arithmetic.leetcode;

import java.util.Objects;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 *
 * @author luohaoyu
 * @since 2019-01-15 20:42
 **/
public class MatrixFound {
    /**
     * 思路：从右上角开始找
     *
     * @param targetNumber
     * @param matrix
     * @return
     */
    public static boolean findNumInMatrix(int targetNumber, int[][] matrix) {
        if (Objects.isNull(targetNumber) || Objects.isNull(matrix) || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int startRow = 0;
        int startColumn = column - 1;
        while (startRow <= row - 1 && startColumn >= 0) {
            //当前点
            int nowNumber = matrix[startRow][startColumn];
            if (targetNumber == nowNumber) {
                return true;
            }
            if (targetNumber > nowNumber) {
                startRow++;
            } else {
                startColumn--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3, 5}, {2, 4, 6}, {7, 9, 10}};
        System.out.println(findNumInMatrix(15, input));
        String a = "We Are Happy";
        System.out.println(a.replace(" ","%20"));
    }
}
