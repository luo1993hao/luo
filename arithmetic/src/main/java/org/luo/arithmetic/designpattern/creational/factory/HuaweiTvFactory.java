package org.luo.arithmetic.designpattern.creational.factory;

public class HuaweiTvFactory implements TvFactory {
    @Override
    public Tv create() {
        return new HuaweiTv();
    }
}
