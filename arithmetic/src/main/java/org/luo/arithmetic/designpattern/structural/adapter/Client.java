package org.luo.arithmetic.designpattern.structural.adapter;

import org.luo.arithmetic.designpattern.structural.adapter.object.*;
import org.luo.arithmetic.designpattern.structural.adapter.classes.ClassAdapter;

/**
 * 场景：
 * 接口不兼容而不能一起工作的那些类可以在一起工作。
 *
 * 适配器模式涉及3个角色：
 * 1.源（Adaptee）：需要被适配的对象或类型，相当于插头。
 * 2.适配器（Adapter）：连接目标和源的中间对象，相当于插头转换器。
 * 3.目标（Target）：期待得到的目标，相当于插座。
 * 适配器模式包括3种形式：类适配器模式、对象适配器模式、接口适配器模式（或又称作缺省适配器模式）。
 *
 * <p>
 * 方式：
 * 1.类的适配器
 * 使用继承的方式
 * 优点：简单
 * 缺点：不灵活
 * 2.对象适配器
 * 使用组合的方式，adapter类中持有Adaptee的引用
 * 优点：灵活
 * 缺点：代码较复杂一些
 * 3.缺省适配器
 * 在接口与实现类中间加入一层抽象类，实现部分方法，这样实现类不用全部实现接口的所有方法，在jdk中大量使用。例如list的AbstractList，map的AbstractMap
 * 源码中的使用：
 * java.util.Arrays#asList()
 * java.util.Collections#list()
 * java.util.Collections#enumeration()
 * java.io.InputStreamReader(InputStream) （返回 Reader对象）
 * java.io.OutputStreamWriter(OutputStream) （返回 Writer对象）
 * 个人感觉：建议尽量使用对象的适配器模式，多用合成/聚合、少用继承
 */
public class Client {
    public static void main(String[] args) {
        //类的适配器
        Target mAdapter = new ClassAdapter();
        mAdapter.Request();
        //对象适配器
        Target mAdapter1 = new ObjectAdapter(new Adaptee());
        mAdapter1.Request();
    }
}
