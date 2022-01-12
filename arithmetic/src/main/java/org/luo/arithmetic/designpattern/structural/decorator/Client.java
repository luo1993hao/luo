package org.luo.arithmetic.designpattern.structural.decorator;

/**
 * 装饰者模式指的是在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。
 * 它是通过创建一个包装对象，也就是装饰者来包裹真实的对象。
 * 装饰者对象和具体构件有相同的接口。这样客户端对象就能以和真实对象相同的方式和装饰对象交互。
 * 组成结构：
 * 抽象构件 (Component)：给出抽象接口或抽象类，以规范准备接收附加功能的对象。
 * 具体构件 (ConcreteComponent)：定义将要接收附加功能的类。
 * 抽象装饰 (Decorator)：装饰者共同要实现的接口，也可以是抽象类。
 * 具体装饰 (ConcreteDecorator)：持有一个 Component 对象，负责给构件对象“贴上”附加的功能。
 * <p>
 * 场景：
 * 当不能采用生成子类的方法进行扩充时。可能有大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。
 * <p>
 * 优点：
 * 无需创建新子类即可扩展对象的行为。
 * 可以在运行时添加或删除对象的功能。
 * 可以用多个装饰封装对象来组合几种行为。
 * 缺点：
 * 类较多，如果出错，需要一层一层剥离定位问题。
 *
 * <p>
 *
 *   源码中的使用：
 *   java.io.InputStream、 OutputStream、 Reader 和 Writer 的所有代码都有以自身类型的对象作为参数的构造函数。（）
 * 个人总结：
 * 1.用继承来扩展对象行为的方案难以实现或者根本不可行的时候，考虑装饰者模式
 * 2.核心思想还是跟组合模式一致，装饰者类和被装饰类公用一个接口，使用组合的方式，增加被装饰类的功能。（组合模式仅仅是将component类的东西分发给了leaf类）
 * 3.业务代码中慎重，除非能找到被装饰类和装饰类通用的方法。
 * 4.装饰的生成则总是由客户端进行控制
 */
public class Client {
    public static void main(String[] args) {

        //简单要一杯浓咖啡
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + "$" + beverage1.cost());

        //两份摩卡加一份豆浆的浓咖啡
        Beverage beverage2 = new Soy(new Mocha(new Mocha(new Espresso())));
        System.out.println(beverage2.getDescription() + "$" + beverage2.cost());

        //一份摩卡加一份豆浆的黑咖啡
        Beverage beverage3 = new Soy(new Mocha(new HouseBlend()));
        System.out.println(beverage3.getDescription() + "$" + beverage3.cost());
    }
}
