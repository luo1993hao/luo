package org.luo.arithmetic.designpattern.behavioral.state;

public interface LevelState {

    /**
     * 左转
     *
     * @param context
     */
    void left(Context context);

    /**
     * 右转
     *
     * @param context
     */
    void right(Context context);

    /**
     * 当前档位
     * @return
     */
    String info();
}