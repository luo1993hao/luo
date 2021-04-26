package org.luo.practice.concurrent;

import org.openjdk.jol.info.ClassLayout;

public class TwoUserMain {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        synchronized (user) {
            System.out.println("--MAIN--:" + ClassLayout.parseInstance(user).toPrintable());
        }

        Thread thread = new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD--:" + ClassLayout.parseInstance(user).toPrintable());
            }
        });
        thread.start();
        thread.join();
        System.out.println("--END--:" + ClassLayout.parseInstance(user).toPrintable());
    }
}
