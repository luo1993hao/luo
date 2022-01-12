package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 具体被装饰类（也可以加一层抽象被装饰类）
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee ";
    }
    
    @Override
    public double cost() {
        return 0.80;
    }
}