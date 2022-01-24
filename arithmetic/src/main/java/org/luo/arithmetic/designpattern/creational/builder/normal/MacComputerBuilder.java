package org.luo.arithmetic.designpattern.creational.builder.normal;


public class MacComputerBuilder extends ComputerBuilder {
    private NormalComputer computer;

    public MacComputerBuilder(String cpu, String ram) {
        computer = new NormalComputer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("苹果键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("苹果显示器");
    }

    @Override
    public NormalComputer getComputer() {
        return computer;
    }
}
