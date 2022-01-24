package org.luo.arithmetic.designpattern.creational.builder.normal;

public class LenovoComputerBuilder extends ComputerBuilder {
    private NormalComputer computer;
    public LenovoComputerBuilder(String cpu, String ram) {
        computer=new NormalComputer(cpu,ram);
    }
    @Override
    public void setUsbCount() {
        computer.setUsbCount(4);
    }
    @Override
    public void setKeyboard() {
        computer.setKeyboard("联想键盘");
    }
    @Override
    public void setDisplay() {
        computer.setDisplay("联想显示器");
    }
    @Override
    public NormalComputer getComputer() {
        return computer;
    }
}
