package org.luo.arithmetic.designpattern.structural.proxy;

public class TargetImpl implements Target {

    public void save() {
        System.out.println("----已经保存数据!----");
    }
}