package org.luo.arithmetic.designpattern.structural.flyweight;

import java.awt.*;

/**
 * 定义：
 * 允许使用对象共享来有效地支持大量细粒度对象
 * 享元模式，个人理解为"共享原数据对象模式"。
 * <p>
 * 类组成：
 * 3个部分组成
 * Flyweight
 * 享元接口，定义所有对象共享的操作
 * ConcreteFlyweight
 * 具体的要被共享的对象，其一般是一个不可变类，内部只保存需要共享的内部状态，它可能不止一个。
 * FlyweightFactory
 * 负责给客户端提供共享对象
 * <p>
 * 核心概念：
 * 1.共享对象的状态分为内部状态与外部状态，内部状态在各个对象间共享，而外部状态由客户端传入。
 * <p>
 * 享元模式建议不在对象中存储外在状态， 而是将其传递给依赖于它的一个特殊方法。
 * 程序只在对象中保存内在状态， 以方便在不同情景下重用。 这些对象的区别仅在于其内在状态
 * （与外在状态相比， 内在状态的变体要少很多）， 因此你所需的对象数量会大大削减。
 * 外部状态由一个集合保存。
 * <p>
 * 2. 对象不可变
 * <p>
 * <p>
 * 场景：
 * 当你的程序中存在大量相似对象，每个对象之间只是根据不同的使用场景有些许变化时。
 * 具体来说：
 * 1.程序需要生成数量巨大的相似对象
 * 2.这将耗尽目标设备的所有内存
 * 3.对象中包含可抽取且能在多个对象间共享的重复状态。
 *
 * <p>
 * 优点：
 * 极大的降低了程序的内存占用
 * 缺点：
 * 代码更复杂，很难精准找到合适的共享对象。（建议在阅读源码中的使用后，真正找到合适场景再使用）
 *
 * 源码中的使用：
 * 1.java.lang.Integer#valueOf(int) （以及 Boolean、 Byte、 Character、 Short、 Long 和 BigDecimal）
 * 2.各种连接池，对象池。
 * <p>
 * 个人理解：享元模式使用起来其实很简单，单例模式可以看做一个特殊的享元模式。只不过单例模式只有一个实例，而享元模式将对象拆分了两种
 * 状态，内部状态共享，实例的个数就为外部状态的情况，将对象的创建放在了工厂类中。
 * <p>
 * 工厂类也非常简单，使用一个集合存放享元对象。
 * 类似于下面代码（跟缓存使用差不多）：
 * if(collection.get(外部状态) ==null){
 * collection.put(外部状态)
 * }else{
 * //已经存在
 * return collection.get(外部状态) ;
 * }
 * 这样整个系统就只存在n（n= 外部状态的种类个数）个对象
 */
public class Client {

    public static void main(String[] args) {
        //下黑子
        Chess backChess1 = ChessFactory.getChess(Color.BLACK);
        backChess1.draw(2, 5);

        //下白子
        Chess whiteChess = ChessFactory.getChess(Color.WHITE);
        whiteChess.draw(3, 5);

        //下黑子
        Chess backChess2 = ChessFactory.getChess(Color.BLACK);
        backChess2.draw(2, 6);

        System.out.printf("backChess1:%d | backChess2:%d | whiteChess:%d%n",
                backChess1.hashCode(), backChess2.hashCode(), whiteChess.hashCode());

    }

}
