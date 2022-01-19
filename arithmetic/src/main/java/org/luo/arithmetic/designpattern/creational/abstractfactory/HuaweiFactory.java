package org.luo.arithmetic.designpattern.creational.abstractfactory;

public class HuaweiFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Tv createTv() {
        return new HuaweiTv();
    }
}
