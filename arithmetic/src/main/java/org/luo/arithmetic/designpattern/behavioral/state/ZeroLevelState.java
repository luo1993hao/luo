package org.luo.arithmetic.designpattern.behavioral.state;


public class ZeroLevelState implements LevelState {

    @Override
    public void left(Context context) {
        context.setLevelState(this);
    }

    @Override
    public void right(Context context) {
        LevelState levelState = new OneLevelState();
        context.setLevelState(levelState);
    }

    @Override
    public String info() {
        return "0档";
    }

}