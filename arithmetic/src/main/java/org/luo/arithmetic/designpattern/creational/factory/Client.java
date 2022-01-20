package org.luo.arithmetic.designpattern.creational.factory;

/**
 * 定义：
 * 定义一个用于创建对象的接口，让子类决定实例化哪个类
 * 和简单工厂模式中工厂负责生产所有产品相比，工厂方法模式将生成具体产品的任务分发给具体的产品工厂
 * 场景：
 * 创建复杂一系列对象的时候，并且希望复杂的创建过程对客户端隐藏
 * 主要角色：
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 * <p>
 * <p>
 * <p>
 * 优点：
 * 可以使代码结构清晰，有效地封装变化
 * 对调用者屏蔽具体的产品类。
 * 降低耦合度。
 * 缺点：
 * 每次增加一个产品时，都需要增加一个具体类和对象实现工厂 （抽象工厂解决了这个缺点）
 * <p>
 * 源码中的使用：
 * spring的FactoryBean（如果你想使用工厂设计模式，就让你的工厂实现这个FactoryBean接口。只要实现了这个接口）beanFactory
 * 就是让程序员就是明明白白的告诉Spring, 我这个是工厂Bean，不是用来创造自身的，而是用来给其他的类创建Bean的。
 * 个人理解：
 * 工厂模式角色跟抽象工厂角色一致。工厂模式为抽象工厂的弱化模式。
 * 最大的区别是工厂模式只是生产一种产品（例如小米电脑）。
 * 而抽象工厂是生产一类东西。（例如小米系列产品（电脑，电冰箱））
 * 当抽象工厂模式中每一个具体工厂类只创建一个产品对象，也就是只存在一个产品等级结构时，
 * 抽象工厂模式退化成工厂方法模式；当工厂方法模式中抽象工厂与具体工厂合并，
 * 提供一个统一的工厂来创建产品对象，并将创建对象的工厂方法设计为静态方法时，工厂方法模式退化成简单工厂模式。
 */
public class Client {
    public static void main(String[] args) {
        TvFactory huaweiTvFactory = new HuaweiTvFactory();
        huaweiTvFactory.create();
        TvFactory xiaomiTvFactory = new XiaomiTvFactory();
        xiaomiTvFactory.create();
    }
}
