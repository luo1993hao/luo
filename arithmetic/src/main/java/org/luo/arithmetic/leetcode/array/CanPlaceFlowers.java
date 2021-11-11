package org.luo.arithmetic.leetcode.array;

/**
 * easy 605
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean firstIsOne = false;
        if (flowerbed[0] == 0) {
            firstIsOne = true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            }
        }
        return firstIsOne ? count * 2 + 1 >= n : count * 2 - 1 >= n;
    }

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
    }
}
