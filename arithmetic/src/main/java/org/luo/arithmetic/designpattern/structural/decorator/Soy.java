package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 具体装饰类，核心就是持有抽象组件的引用，并在公用方法那里进行功能增强（装饰作用）
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage = null;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy ";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}