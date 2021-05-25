package org.luo.practice.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("最后输出");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                System.out.println("先 输出");
                countDownLatch.countDown();
            });
        }

    }

}
