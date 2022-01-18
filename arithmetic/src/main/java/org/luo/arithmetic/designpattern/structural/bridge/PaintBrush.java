package org.luo.arithmetic.designpattern.structural.bridge;

public class PaintBrush extends Pen {
    public PaintBrush(PenType penType) {
        super(penType);
    }

    @Override
    void draw() {
        System.out.println(penType.printType());
        System.out.println("我是画笔");
    }
}
