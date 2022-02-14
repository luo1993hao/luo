package org.luo.arithmetic.designpattern.behavioral.state;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Context {

    private LevelState levelState;

    public void left() {
        levelState.left(this);
    }

    public void right() {
        levelState.right(this);
    }

    public String info() {
        return levelState.info();
    }
}