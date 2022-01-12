package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 抽象组件。被装饰类和装饰类都有的方法
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
