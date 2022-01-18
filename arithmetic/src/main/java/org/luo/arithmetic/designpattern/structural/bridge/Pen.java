package org.luo.arithmetic.designpattern.structural.bridge;

import lombok.AllArgsConstructor;

public abstract class Pen {
    protected final PenType penType;

    abstract void draw();

    public Pen(PenType penType) {
        this.penType = penType;
    }
}
