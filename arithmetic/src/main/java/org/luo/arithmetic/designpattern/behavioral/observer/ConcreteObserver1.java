package org.luo.arithmetic.designpattern.behavioral.observer;

class ConcreteObserver1 implements Observer {
    public void update() {
        System.out.println("观察者1收到信息，并进行处理");
    }
}