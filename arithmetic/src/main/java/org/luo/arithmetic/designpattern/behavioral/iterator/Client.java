package org.luo.arithmetic.designpattern.behavioral.iterator;

/**
 * 定义：
 * 提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示
 * 场景：
 * 遍历一个聚合对象
 * 类：
 * Iterator（迭代器接口）：该接口必须定义实现迭代功能的最小定义方法集，比如提供hasNext()和next()方法。（方式）
 * ConcreteIterator（迭代器实现类）：迭代器接口Iterator的实现类。可以根据具体情况加以实现。
 * Aggregate（容器接口）：定义基本功能以及提供类似Iteratoriterator()的方法。（能力）
 * ConcreteAggregate（容器实现类）：容器接口的实现类。必须实现Iteratoriterator()方法。
 * 优点：
 * 职责分离
 * 缺点：
 * 源码中的使用：
 * Java中的Iterator迭代器
 * java.util.Enumeration
 * Iterable与Iterator的区别：
 * Iterator 代表的是迭代的方式
 * Iterable 代表的是迭代的能力以及支持Foreach迭代的方式
 * 如果没有Iterable接口
 * 每一种集合类返回的Iterator具体类型可能不同，Array可能返回ArrayIterator，Set可能返回 SetIterator，
 * Tree可能返回TreeIterator，但是它们都实现了Iterator接口，因此，客户端不关心到底是哪种 Iterator，
 * 它只需要获得这个Iterator接口即可，这就是面向接口编程。
 * 个人理解：
 * 该模式的核心思想就是将集合类的存储与遍历职责分开。
 * 该模式属于日常开发中几乎使用不到的一种模式。迭代器模式属于给集合遍历使用，我们很少自己写一个集合（自己写一个tree的情况下可能会使用）。
 * jdk中Iterator迭代器中Iterable就等于上述的Aggregate类
 */
public class Client {
}
