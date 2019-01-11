package org.luo.arithmetic.sort;

/**
 * 排序基类
 *
 * @author luohaoyu
 * @since 2019-01-10 20:55
 **/
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

