package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 抽象装饰类
 */
public abstract class CondimentDecorator extends Beverage{
    @Override
    public abstract String getDescription();
}