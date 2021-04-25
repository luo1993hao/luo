package org.luo.practice.concurrent;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        //查看对象的内存布局
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        System.out.println(VM.current().details());

    }

}
