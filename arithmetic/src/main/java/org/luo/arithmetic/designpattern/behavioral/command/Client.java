package org.luo.arithmetic.designpattern.behavioral.command;

import org.luo.arithmetic.designpattern.behavioral.command.notuse.Invoker;
import org.luo.arithmetic.designpattern.behavioral.command.notuse.Receiver;
import org.luo.arithmetic.designpattern.behavioral.command.use.*;
import org.luo.arithmetic.designpattern.behavioral.command.use.composite.MacroAudioCommand;
import org.luo.arithmetic.designpattern.behavioral.command.use.composite.MacroCommand;

/**
 * 定义：
 * 命令模式把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化，
 * 对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
 * 场景：
 * 1.需要抽象出等待执行的行为，比如撤销（Undo）操作和恢复（Redo）等操作,使其请求调用者和请求的接收者需要解耦，使得调用者和接收者不直接交互。
 * 2.需要支持命令宏（命令组合操作）
 * 类结构：
 * <p>
 * Command（抽象命令类）：抽象命令类一般是一个抽象类或接口，在其中声明了用于执行请求的execute()等方法，通过这些方法可以调用请求接收者的相关操作。
 * ConcreteCommand（具体命令类）：具体命令类是抽象命令类的子类，实现了在抽象命令类中声明的方法，它对应具体的接收者对象，将接收者对象的动作绑定其中。在实现execute()方法时，将调用接收者对象的相关操作(Action)。
 * Invoker（调用者）：调用者即请求发送者，它通过命令对象来执行请求。
 * 一个调用者并不需要在设计时确定其接收者，因此它只与抽象命令类之间存在关联关系。
 * 在程序运行时可以将一个具体命令对象注入其中，
 * 再调用具体命令对象的execute()方法，从而实现间接调用请求接收者的相关操作。
 * Receiver（接收者）：接收者执行与请求相关的操作，它具体实现对请求的业务处理。
 * 优点：
 * 1.解耦，请求者与接收者实现完全解耦。
 * 2.满足开闭原则。新的命令可以很容易地加入到系统中。
 * 3.可以比较容易地设计一个命令队列或宏命令（组合命令）。
 * 4.为请求的撤销(Undo)和恢复(Redo)操作提供了一种设计和实现方案。
 * 缺点：
 * 设计模式老毛病，具体命令类增多，导致系统复杂。
 * 源码使用：
 * 1.spring的jdbcTemplate中 query方法的StatementCallback参数，StatementCallback就是命令接口。而匿名内部类QueryStatementCallback为命令的接收者
 * JdbcTemplate就是命令的调用者。
 * 2.jdk中的runnable接口。runnable就是命令接口。只要实现了runnable接口的类就相当用具体的命令。Thread就是调用者。
 * eg:
 * class T implements Runnable{...}
 * Thread t1 = new Thread(new T());
 * t1.start();
 *
 * 个人理解：
 * 未使用命令模式之前发送命令的流程：调用方->接收者 （将军->士兵）
 * 使用命令模式发送命令的流程：调用方拼装命令->调用者->接收者（将军将命令弄成军令状，贴在墙上。士兵去领军令状完成命令）
 * 此时调用方只用拼装命令。调用者持有命令，负责根据命令类型找到具体的接收者，执行接收者的方法。
 * 核心思想就是引入了命令类，将命令封装成了对象。
 * 命令模式可以将请求发送者和接收者完全解耦，发送者与接收者之间没有直接引用关系，
 * 发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求。
 */
public class Client {
    public static void main(String[] args) {
        //1.调用者直接发出命令给接收者。可以看到在发出命令的时候。发送者与接收者是耦合的。发送者持有接收者的引用
        Invoker invoker = new Invoker(new Receiver());
        invoker.invokeReceiver();

        //2.客户端拼装命令->给调用者->调用者给接收者
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        //创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
        //3.命令的组合

        //创建接收者对象
        AudioPlayer audioPlayer1 = new AudioPlayer();
        //创建命令对象
        Command playCommand1 = new PlayCommand(audioPlayer1);
        Command rewindCommand1 = new RewindCommand(audioPlayer1);
        Command stopCommand1 = new StopCommand(audioPlayer1);

        MacroCommand marco = new MacroAudioCommand();

        marco.add(playCommand1);
        marco.add(rewindCommand1);
        marco.add(stopCommand1);
        marco.execute();
    }
}

