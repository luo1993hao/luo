package org.luo.arithmetic.designpattern.creational.builder.normal;

public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setDisplay();
        builder.setKeyboard();
    }

    //如果顺序不同，创建的对象也不同的话。这里还可以有其他方法
    public void makeComputer1(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setKeyboard();
        builder.setDisplay();
    }
}
