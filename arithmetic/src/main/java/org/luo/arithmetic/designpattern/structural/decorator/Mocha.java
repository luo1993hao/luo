package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 具体装饰类，核心就是持有抽象组件的引用，并在公用方法那里进行功能增强（装饰作用）
 */
public class Mocha extends CondimentDecorator {
    /**
     * 组合思想
     */
    private Beverage beverage = null;    //用一个实例变量来记录饮料，也就是被装饰者

    public Mocha(Beverage beverage) {
        this.beverage = beverage;    //通过构造函数将被装饰者实例化
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha ";    //用来加上调料，一起描述饮料
    }

    @Override
    /**
     * 进行增强（装饰）
     */
    public double cost() {
        return 0.2 + beverage.cost();    //计算摩卡饮料的价钱，为摩卡价钱 + 饮料价钱
    }
}