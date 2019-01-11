package org.luo.practice.binary;

/**
 * 关于jdk源码中一些二进制操作的验证
 *
 * @author luohaoyu
 * @since 2019-01-09 20:28
 **/
public class BinaryOperation {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(32));
    }

    /**
     * {@link java.util.concurrent.ConcurrentHashMap} 中扩容步骤
     *
     * @param c
     * @return
     */
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE - 8 : n + 1;
    }
}
