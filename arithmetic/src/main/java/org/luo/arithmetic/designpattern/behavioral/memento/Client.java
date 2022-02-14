package org.luo.arithmetic.designpattern.behavioral.memento;

/**
 * 定义：
 * <p>
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存着这个状态。这样以后就可将该对象恢复到原先保存的状态。
 * 场景：
 * 需要保存历史快照的场景
 * 类定义：
 * 发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，
 * 实现其他业务功能，它可以访问备忘录里的所有信息。
 * 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * 以便根据这些数据恢复这个发起人对象的内部状态。
 * 优点：
 * 1.提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。
 * 2.实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
 * 3.简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，
 * 并由管理者进行管理，这符合单一职责原则。
 * 缺点：
 * 资源消耗，如果保存状态过多时，每一次保存都会消耗内存
 * 源码中的使用：
 * Spring webflow StateManageableMessageContext
 * 其他很少使用
 * 个人理解：
 * 核心思想在于“后悔药”、”历史快照”.如果仅仅只是完成这2个功能，只需要发起人，管理者2个角色即可。
 * 但是这样的话。"发起人"类职责就过多，一要满足业务需求，二要保存和管理内部状态的各个备份。所以
 * 代码核心是增加了备忘录管理类（迪米特原则）。客户不与备忘录类耦合，与备忘录管理类耦合。这也就是上述的优点2.3。
 * 个人感觉这个模式用的太少了，无论是日常写业务代码 ，还是目前常见的源码里面，都很少使用。
 */
public class Client {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}

