package org.luo.arithmetic.designpattern.creational.factory;

public class XiaomiTvFactory implements TvFactory{
    @Override
    public Tv create() {
        return new XiaomiTv();
    }
}
