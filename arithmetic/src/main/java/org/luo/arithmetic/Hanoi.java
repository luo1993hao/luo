package org.luo.arithmetic;
/**
 * 汉诺塔问题
 * step1:将 n-1 个圆盘从 from -> buffer
 * step2:将 1 个圆盘从 from -> to
 * step3:将 n-1 个圆盘从 buffer -> to
 *
 * @author luohaoyu
 * @since 2019-01-10 21:47
 **/
public class Hanoi {
    public static void move(int n, String from, String buffer, String to) {
         if (n == 1) {
            System.out.println("from " + from + " to " + to);
            return;
        }
        move(n - 1, from, to, buffer);
        move(1, from, buffer, to);
        move(n - 1, buffer, from, to);
    }

    public static void main(String[] args) {
        Hanoi.move(3, "H1", "H2", "H3");
    }
}
