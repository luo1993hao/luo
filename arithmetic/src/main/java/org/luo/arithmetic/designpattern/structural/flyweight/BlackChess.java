package org.luo.arithmetic.designpattern.structural.flyweight;

import org.luo.arithmetic.designpattern.structural.flyweight.Chess;

import java.awt.*;

//黑棋
public class BlackChess implements Chess {
    //内部状态，共享
    private final Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(int x, int y) {
        String sharp = "圆形";
        System.out.printf("%s%s棋子置于（%d，%d）处%n", sharp, color.getAlpha(), x, y);
    }
}
