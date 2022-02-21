package org.luo.arithmetic.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    private List<Observer> obs = new ArrayList<>();

    public void addObserver(Observer obs) {
        this.obs.add(obs);
    }

    public void delObserver(Observer obs) {
        this.obs.remove(obs);
    }

    protected void notifyObserver() {
        for (Observer o : obs) {
            o.update();
        }
    }

    public abstract void doSomething();
}