package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 具体被装饰类，（也可以加一层抽象被装饰类）
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso ";
    }
    
    @Override
    public double cost() {
        return 1.99;
    }
}