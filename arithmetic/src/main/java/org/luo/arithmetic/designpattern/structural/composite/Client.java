package org.luo.arithmetic.designpattern.structural.composite;

/**
 * 场景：
 * 当你的程序结构有类似树一样的层级关系时，例如文件系统，视图树，公司组织架构等等
 * 当你要以统一的方式操作单个对象和由这些对象组成的组合对象的时候。
 * 优点：
 * 1.你可以利用多态和递归机制更方便地使用复杂树结构。
 * 2.开闭原则。无需更改现有代码， 你就可以在应用中添加新元素， 使其成为对象树的一部分。
 * 缺点：
 * 对于功能差异较大的类， 提供公共接口或许会有困难。 在特定情况下， 你需要过度一般化组件接口， 使其变得令人难以理解。
 * 使用方式：
 * 1.安全模式
 * composite类和leaf类区别对待，不必实现component的所有实现
 * 优点：足够安全
 * 缺点：能完全针对抽象编程，必须有区别地对待叶子构件和容器构件。
 * 2.透明模式
 * composite类和leaf类实现component的所有实现
 * 优点：确保所有的构件类都有相同的接口
 * 缺点：不够安全，因为叶子对象和容器对象在本质上是有区别的，叶子对象不可能有下一个层次的对象。有可能出现运行时错误
 * 源码中的使用：
 * hashMap的putAll方法
 * map为抽象类
 * hashMap为容器类
 * entry为叶子类
 * 个人理解：该设计模式日常开发中慎用,组合模式的核心思想就是树形结构+递归。组合模式适用于底层框架代码，学习该设计模式对阅读源码有一定帮助。
 */
public class Client {
    public static void main(String[] args) {
        Folder DSFolder = new Folder("设计模式资料");
        File note1 = new File("组合模式笔记.md", "组合模式组合多个对象形成树形结构以表示具有 \"整体—部分\" 关系的层次结构");
        File note2 = new File("工厂方法模式.md", "工厂方法模式定义一个用于创建对象的接口，让子类决定将哪一个类实例化。");
        DSFolder.add(note1);
        DSFolder.add(note2);

        Folder codeFolder = new Folder("样例代码");
        File readme = new File("README.md", "# 设计模式示例代码项目");
        Folder srcFolder = new Folder("src");
        File code1 = new File("组合模式示例.java", "这是组合模式的示例代码");

        srcFolder.add(code1);
        codeFolder.add(readme);
        codeFolder.add(srcFolder);
        DSFolder.add(codeFolder);

        DSFolder.print();
    }

}

