package org.luo.arithmetic.designpattern.behavioral.observer;

class ConcreteSubject extends Subject {
    public void doSomething(){
        System.out.println("被观察者事件发生改变");
        this.notifyObserver();
    }
}