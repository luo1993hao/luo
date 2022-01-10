package org.luo.arithmetic.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * composite类，把具体工作转交给leaf类去做
 组合模式的核心就在于
 1.继承Component但又持有list的Component引用
 2.具体实现的时候遍历/递归去给leaf类实现
 */
public class Folder extends Component {
    private final String name;
    /**
     * 核心
     */
    private final List<Component> componentList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Component component) {
        this.componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        this.componentList.remove(component);
    }

    @Override
    public void print() {
        System.out.println(this.getName());
        /**
         * 核心
         */
        for (Component component : this.componentList) {
            component.print();
        }
    }
}
