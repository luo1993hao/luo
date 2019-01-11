package org.luo.arithmetic.sort;

/**
 * 冒泡排序
 *
 * @author luohaoyu
 * @since 2019-01-10 20:34
 **/
public class BubbleSort extends Sort<Integer> {
    @Override
    public void sort(Integer[] in) {

        for (int i = 0; i < in.length; i++) {
            for (int j = i; j < in.length - 1; j++) {
                if (less(in[j], in[j + 1])) {
                    swap(in, j, j + 1);
                }
            }
        }
    }
}
