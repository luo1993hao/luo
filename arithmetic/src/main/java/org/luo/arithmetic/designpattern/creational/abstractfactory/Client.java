package org.luo.arithmetic.designpattern.creational.abstractfactory;

/**
 * 定义：
 * 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类；具体的工厂负责实现具体的产品实例。
 * <p>
 *
 * <p>
 * 场景：
 * 1. 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
 * 2. 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
 * 3. 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
 *
 * <p>
 * 角色：
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 * <p>
 * 对场景和角色的举例：
 * 有一个要创建手机和电视机的实例的需求。手机有小米，华为。电视机也有小米，华为。这时候就可以创建一个抽象工厂。里面2个方法
 * createPhone(),createTv()。2个具体工厂。
 * XiaoMiFactory生产XiaomiPhone和XiaomiTv
 * HuaWeiFactory生产HuaweiPhone和HuaweiTv
 * 抽象产品为Phone和Tv
 * 具体产品为XiaomiPhone 和XiaomiTv
 * HuaweiPhone和HuaweiTv
 * 优点：
 * 1. 当增加一个新的产品时只需增加一个新的具体工厂，不需要修改原代码，满足开闭原则。(比如增加苹果品牌)
 * 2 符合单一职责
 * 缺点：
 * 1.当产品族中需要增加一个新种类的产品时，则所有的工厂类都需要进行修改，不满足开闭原则。(比如增加了电脑)
 * 2.引入过多的类和接口
 * 个人理解：
 * <p>
 * 抽象工厂模式可以这样理解。把产品类型看作x轴（电视机（x1），电冰箱(x2)）。产品类型看作y轴（苹果(y1)，华为(y2)）。这样就有4个产品。(（x1,y1）苹果电视机,
 * (x2,y2)苹果电冰箱，(x1,y2)华为电冰箱，(x1,y2)华为电视机)。
 * 抽象工厂的核心是创建一类东西。抽象工厂模式有点aop的思想。在y轴上画横线。这样就可以分为(y1(x1,x2)苹果电视机，苹果电冰箱,y2(x1,x2)华为电视机，华为电冰箱)
 * 抽象工厂类的方法就是X轴的东西。创建电视机，创建电冰箱。而具体抽象类就是y轴的东西。苹果工厂，华为工厂
 *
 * <p>
 * 抽象工厂是升级版本的升级版本。 解决了工厂方法模式的缺点。
 * 抽象工厂中每个工厂可以创建多种类的产品；而工厂方法每个工厂只能创建一类。
 * <p>
 */
public class Client {

    public static void main(String[] args) {
        //使用小米工厂创建小米系列产品
        AbstractFactory xiaomiFactory = new XiaomiFactory();
        Phone xiaomiPhone = xiaomiFactory.createPhone();
        Tv xiaomiTv = xiaomiFactory.createTv();
        //使用华为工厂创建华为系列产品
        AbstractFactory huaweiFactory = new HuaweiFactory();
        Tv huaweiTv = huaweiFactory.createTv();
        Phone huaweiPhone = huaweiFactory.createPhone();
    }

}
