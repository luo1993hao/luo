package org.luo.arithmetic.designpattern.structural.bridge;

public class BallPointPen extends Pen {
    public BallPointPen(PenType penType) {
        super(penType);
    }

    @Override
    void draw() {
        System.out.println(penType.printType());
        System.out.println("我是圆珠笔");
    }
}
