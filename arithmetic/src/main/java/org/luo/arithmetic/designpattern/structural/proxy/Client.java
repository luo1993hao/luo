package org.luo.arithmetic.designpattern.structural.proxy;

import org.luo.arithmetic.designpattern.structural.proxy.dynamic.CglibProxyFactory;
import org.luo.arithmetic.designpattern.structural.proxy.dynamic.JdkProxyFactory;


/**
 * 定义：
 * 为其他对象提供一个代理以控制对某个对象的访问，即通过代理对象访问目标对象.
 * 这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
 * <p>
 * 方式：
 * 1.静态代理
 * 在编译期确定代理对象，写法跟装饰者模式类似。都是代理类与被代理类公用一个接口，代理类持有被代理类引用，在公用方法里面，进行控制，功能增强。
 * 2.动态代理
 * 2.1 jdk代理
 * 被代理对象必须是接口
 * java.lang.reflect.Proxy.newProxyInstance方法，返回代理类
 * 接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）
 * 2.2 cglib代理
 * 子类代理，它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 * 代理的类不能为final,否则报错
 * 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 * 如果方法为static,private则无法进行代理。
 *
 * 源码：
 * Spring 使用动态代理实现 AOP 时有两个非常重要的类，即 JdkDynamicAopProxy 类和 CglibAopProxy 类
 * <p>
 * 个人总结：
 * 代理模式的核心是"控制"，使用代理类来控制源对象。通常自行管理其服务对象的生命周期
 */
public class Client {
    public static void main(String[] args) {
        //jdk动态代理方式
        // 目标对象
        Target target = new TargetImpl();
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        Target proxy = (Target) new JdkProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();

        //cglib代理
        //目标对象
        TargetImpl target1 = new TargetImpl();
        //代理对象
        TargetImpl proxy1 = (TargetImpl) new CglibProxyFactory(target1).getProxyInstance();

        //执行代理对象的方法
        proxy1.save();

    }
}
