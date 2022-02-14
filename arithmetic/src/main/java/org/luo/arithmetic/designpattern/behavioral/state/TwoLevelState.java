package org.luo.arithmetic.designpattern.behavioral.state;

public class TwoLevelState implements LevelState {

    @Override
    public void left(Context context) {
        LevelState levelState = new OneLevelState();
        context.setLevelState(levelState);
    }

    @Override
    public void right(Context context) {
        context.setLevelState(this);
    }

    @Override
    public String info() {
        return "2档";
    }
}