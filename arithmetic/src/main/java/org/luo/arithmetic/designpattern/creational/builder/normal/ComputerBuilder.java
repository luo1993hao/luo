package org.luo.arithmetic.designpattern.creational.builder.normal;

public abstract class ComputerBuilder {


    //不同的零件交给子类实现，也就是会产生不同的对象
    public abstract void setUsbCount();

    public abstract void setKeyboard();

    public abstract void setDisplay();

    //核心方法
    public abstract NormalComputer getComputer();
}
