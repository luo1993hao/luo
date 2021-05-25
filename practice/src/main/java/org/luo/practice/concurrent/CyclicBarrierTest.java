package org.luo.practice.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("最后执行");
        });
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("先执行" + finalI);
                try {
                    cyclicBarrier.await();
                    System.out.println("子线程又来");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }


}
