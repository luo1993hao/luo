package org.luo.arithmetic.designpattern.behavioral.command.notuse;

public class Invoker {
    private Receiver receiver;

    public Invoker(Receiver receiver) {
        this.receiver = receiver;
    }

    public void invokeReceiver() {
        receiver.execute();
    }
}
