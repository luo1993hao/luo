package org.luo.arithmetic.list.deque;

/**
 * 简单版本，不考虑扩容
 * 核心思想：把数组当作环形
 */
public class ArrayDeque<E> {
    //源码中为2的n次方 扩容条件为headIndex = tailIndex
    private Object[] elements = new Object[16];
    //head data index
    private int headIndex;
    //next data index
    private int tailIndex;

    public void addFirst(E e) {
        //与hashMap一致。其实就是 headIndex%16。
        headIndex = (headIndex - 1) & (elements.length - 1);
        elements[headIndex] = e;
    }

    public void addLast(E e) {
        elements[tailIndex] = e;
        tailIndex = (tailIndex + 1) & (elements.length - 1);

    }

    public void deleteFirst() {
        elements[headIndex] = null;
        headIndex = (headIndex + 1) & (elements.length - 1);
    }

    public void deleteLast() {
        int t = (tailIndex - 1) & (elements.length - 1);
        elements[t] = null;
        tailIndex = t;
    }
}
