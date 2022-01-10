package org.luo.arithmetic.designpattern.structural.composite;

public abstract class Component {

    public String getName() {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public void add(Component component) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public void print() {
        throw new UnsupportedOperationException("不支持打印操作");
    }

    public String getContent() {
        throw new UnsupportedOperationException("不支持获取内容操作");
    }
}
