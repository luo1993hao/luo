package org.luo.arithmetic.designpattern.creational.builder;

import org.luo.arithmetic.designpattern.creational.builder.normal.*;
import org.luo.arithmetic.designpattern.creational.builder.simple.SimpleComputer;

/**
 * 定义：
 * 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，
 * 这样的设计模式被称为建造者模式。它是将一个复杂的对象分解为多个简单的对象，
 * 然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 * 场景：
 * 1. 类的属性较多，构造函数参数特别多,并且部分参数是可选的时候（大于5-6个）（分离对象的属性和创建过程，屏蔽复杂细节，只暴露部分可选参数给构建者）
 * 2.产品类非常复杂，或者产品类中不同的调用顺序产生不同的作用。
 * <p>
 * <p>
 * 类：
 * 1.产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 2.抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 3.具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 4.指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。(可以看作是一个工厂)
 * 优点：
 * 1.客户端不比知道产品内部细节，将产品本身与产品创建过程解耦，使得相同的创建过程可以创建不同的产品对象
 * 2.可以更加精细地控制产品的创建过程，将复杂对象分门别类抽出不同的类别来，使得开发者可以更加方便地得到想要的产品
 * 缺点：
 * 类增加，代码更为复杂
 * 源码中的使用：
 * 1.mybatis的SqlSessionFactoryBuilder。用于创建SqlSessionFactory。屏蔽了开发者对核心类Configuration的创建过程
 * 2.jdk中StringBuilder与StringBuffer
 * 3.spring中一系列以builder结尾的类，比如BeanDefinitionBuilder，UriComponentsBuilder
 * 4.java.lang.Appendable的所有实现
 *
 * 个人理解：
 * 创建者模式标准模式包括如上4种角色，所适用的场景对应上述的场景2。
 * 主要用于封装复杂对象的创建，由指挥者提供不同的方法来创建不同的对象。
 * 而对于场景1来说，不需要抽象建造者与指挥者。我们的主要目的是去掉又长又难以理解的构造函数。
 * 直接在product里面内嵌一个具体建造者的内部类即可。
 *
 *
 * 个人感觉创建者模式有3个核心思想，有两个为适用场景所表达的思想：
 * 1.链式调用，各个参数之间没有什么联系。jdk中StringBuilder与StringBuffer。我们常用的lombok的@Builder。可以理解为简化版创建者模式的特殊场景
 * 2.参数较多，部分必填。简化构造函数
 * 3.当类对象属性之间有关联，有一些必填参数，加上当你拼装顺序属性的顺序不同，而造成不同的对象。这些细节想给创建者屏蔽的时候.

 * <p>
 * 与工厂模式的区别主要
 * 1.在于意图/侧重点不一样。工厂模式在于对象的创建，只要对象创建出来就可以了。而建造者模式不仅要创建出对象，还要知道对象由哪些部件组成。
 * 2.建造者模式根据建造过程中的顺序不一样，最终对象部件组成也不一样。而工厂模式创建的对象都一样。
 */
public class Client {
    public static void main(String[] args) {
        //1.简化版本
        SimpleComputer computer = new SimpleComputer.Builder("因特尔", "三星")
                //下面三个参数可选
//                .setDisplay("三星24寸")
//                .setKeyboard("罗技")
//                .setUsbCount(2)
                .build();

        //2.普通版本
        ComputerDirector director = new ComputerDirector();//1
        ComputerBuilder builder = new MacComputerBuilder("I5处理器", "三星125");//2
        director.makeComputer(builder);//3
        NormalComputer macComputer = builder.getComputer();//4
        System.out.println("mac computer:" + macComputer.toString());

        ComputerBuilder lenovoBuilder = new LenovoComputerBuilder("I7处理器", "海力士222");
        director.makeComputer(lenovoBuilder);
        NormalComputer lenovoComputer = lenovoBuilder.getComputer();

    }
}
