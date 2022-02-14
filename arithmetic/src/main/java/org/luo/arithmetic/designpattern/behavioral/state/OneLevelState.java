package org.luo.arithmetic.designpattern.behavioral.state;

public class OneLevelState implements LevelState {

    @Override
    public void left(Context context) {
        LevelState levelState = new ZeroLevelState();
        context.setLevelState(levelState);
    }

    @Override
    public void right(Context context) {
        LevelState levelState = new TwoLevelState();
        context.setLevelState(levelState);
    }

    @Override
    public String info() {
        return "1档";
    }
}