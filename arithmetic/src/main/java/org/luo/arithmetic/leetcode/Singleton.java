package org.luo.arithmetic.leetcode;

/**
 * 单列模式
 *
 * @author luohaoyu
 * @since 2019-01-23 12:00
 **/
public class Singleton {
    /**
     * 禁止指令重排序，保证多线程下线程安全
     */
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

