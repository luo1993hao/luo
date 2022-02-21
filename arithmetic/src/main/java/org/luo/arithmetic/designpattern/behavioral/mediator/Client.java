package org.luo.arithmetic.designpattern.behavioral.mediator;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 定义：
 * 定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，
 * 且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 * 场景：
 * 对象与对象之间存在大量的关联关系，这样势必会导致系统的结构变得很复杂，
 * 同时若一个对象发生改变，我们也需要跟踪与之相关联的对象，同时做出相应的处理。
 * 多个类相互耦合，形成了网状结构.
 * 比如：
 * 调度中心：统一分配资源的场景都可以使用中介模式,比如线程池
 * 注册中心: 通过中介者登记并提供服务
 * 媒体网关: 通过中介者进行消息转发
 * 类结构：
 * 抽象中介者(Mediator)角色：定义出同事对象到中介者对象的接口，其中主要方法是一个（或多个）事件方法。
 * 具体中介者(ConcreteMediator)角色：实现了抽象中介者所声明的事件方法。具体中介者知晓所有的具体同事类，并负责具体的协调各同事对象的交互关系。
 * 抽象同事类(Colleague)角色：定义出中介者到同事对象的接口。同事对象只知道中介者而不知道其余的同事对象。
 * 具体同事类(ConcreteColleague)角色：所有的具体同事类均从抽象同事类继承而来。实现自己的业务，在需要与其他同事通信的时候，就与持有的中介者通信，中介者会负责与其他的同事交互。
 * 优点：
 * 1.降低了对象之间的耦合性，使得对象易于独立地被复用。
 * 2.将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 * 缺点：
 * 1.中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越臃肿，变得复杂且难以维护。
 * 2.中介出问题，整个程序玩完，道理和卖房中介卷钱跑路一样
 * 源码使用：
 * 1.java.util.Timer
 * Timer timer = new Timer();
 * timer.schedule(new MyOneTask(), 3000, 1000); // 3秒后开始运行，循环周期为 1秒
 * timer.schedule(new MyTwoTask(), 3000, 1000);
 * Timer 这个中介者的功能就是定时调度我们写的各种任务，
 * <p>
 * 给 TimerThread 执行，让任务与执行线程解耦。
 * 2. MVC模式中，Controller 是中介者，根据 View 层的请求来操作 Model 层
 * java.util.concurrent.Executor#execute 和 java.util.concurrent.ExecutorService#submit 与 Timer#schedule 类似
 * 个人理解：
 * <p>
 * 核心思想就是当众多类相互引用的时候，使用一个中介类来降低耦合。
 * 微服务的注册中心也可以理解为中介者。
 * 没有注册中心之前微服务之间相互引用。整个依赖关系形成了网状，关系错综复杂，非常难以管理。有了过后他们之间的关系就从"网状"->以注册中心为中心的"星状"
 * 微服务之间就没有直接联系。
 * 个人感觉中介者模式在日常使用中谨慎使用。在我们正常开发时，一个对象引用几个对象，太正常不过。
 * 如果无脑的使用中介者模式，必然带来项目代码紊乱。
 */
public class Client {
    public static void main(String[] args)  {
        // 实例化房屋中介
        Mediator mediator = new HouseMediator();

        Person landlordA, landlordB, renter;
        landlordA = new Landlord("房东李", mediator);
        landlordB = new Landlord("房东黎", mediator);

        renter = new Renter("小吕", mediator);

        // 房东注册中介
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);
        // 求租者注册中介
        mediator.registerRenter(renter);

        // 求租者 发送求租消息
        renter.sendMessage("在天河公园附近租套房子，价格1000元左右一个月");
        System.out.println("--------------------------");
        // 房东A 发送房屋出租消息
        landlordA.sendMessage("天河公园学院站三巷27号四楼有一房一厅出租  1200/月  光线好 近公交站");

    }
}
