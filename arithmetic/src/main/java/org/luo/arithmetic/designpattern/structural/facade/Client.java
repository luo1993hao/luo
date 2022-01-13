package org.luo.arithmetic.designpattern.structural.facade;

/**
 * 定义：提供了一个统一的接口，用来访问子系统中的一群接口。
 * <p>
 * 门面模式没有固定的um类图。总的来说就是使用一个facade类/接口 去组合复杂的子系统
 * <p>
 * 场景：
 * 为一个复杂模块或者子系统提供一个简介的供外部访问的接口。
 * <p>
 * 优点：
 * 1）简化了调用过程，不用深入了解子系统，以防给子系统带来风险。
 * （2）减少系统依赖，松散耦合。
 * （3）更好的划分访问层次，提高安全性。
 * （4） 迪米特法则的很好实践
 * 缺点：
 * （1）当增加子系统和扩展子系统时，可能容易带来未知风险。
 * （2）不符合开闭原则。
 * （3）外观可能成为与程序中所有类都耦合的上帝对象。
 * 源码：
 * mybatis的configuration中的forObject方法。（objectFactory，objectWrapperFactory，reflectorFactory看作三个子系统）
 * 个人理解：
 * 通俗一点可以认为这个模式是将子系统封装到一起，提供给应用的层面就提供一个方法。不直接由应用层直接访问子系统。核心思想就是提供一个门面类，提供一个新方法来组合子系统的方法
 */
public class Client {
    public static void main(String[] args) {
        new ReportFacade().generateReport();
    }
}
