package org.luo.practice.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        User user = new User();
//        //查看对象的内存布局
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
//
//        System.out.println(VM.current().details());
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> System.out.println("test"));

    }

}
