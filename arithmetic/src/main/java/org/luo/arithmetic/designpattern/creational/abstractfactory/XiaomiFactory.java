package org.luo.arithmetic.designpattern.creational.abstractfactory;

public class XiaomiFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Tv createTv() {
        return new XiaomiTv();
    }
}
