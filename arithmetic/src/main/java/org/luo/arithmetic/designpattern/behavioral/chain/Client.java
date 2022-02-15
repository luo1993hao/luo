package org.luo.arithmetic.designpattern.behavioral.chain;

import org.luo.arithmetic.designpattern.behavioral.chain.general.*;
import org.luo.arithmetic.designpattern.behavioral.chain.standard.AbstractPrepareFilter;
import org.luo.arithmetic.designpattern.behavioral.chain.standard.HaveBreakfastFilter;
import org.luo.arithmetic.designpattern.behavioral.chain.standard.WashFaceFilter;
import org.luo.arithmetic.designpattern.behavioral.chain.standard.WashHairFilter;

/**
 * 定义：
 * 为了避免请求发送者与多个请求处理者耦合在一起，于是将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 * 特点：
 * 1.链上的每个对象都有机会处理请求
 * 2.链上的每个对象都持有下一个要处理对象的引用
 * 3.链上的某个对象无法处理当前请求，那么它会把相同的请求传给下一个对象
 * 场景：
 *
 * 类：
 * 1.抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 2.具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，
 * 如果可以处理请求则处理，否则将该请求转给它的后继者。
 * 优点：
 * 1. 降低耦合，发送者与接收者无须拥有对方明确信息
 * 2. 满足开闭原则。
 * 3. 单一职责，每个类只需要处理自己该处理的工作
 * 缺点：
 * 增加复杂性
 * 与其他模式的差异：
 * 责任链模式、 命令模式、 中介者模式和观察者模式用于处理请求发送者和接收者之间的不同连接方式：
 * 责任链按照顺序将请求动态传递给一系列的潜在接收者， 直至其中一名接收者对请求进行处理。
 * 命令在发送者和请求者之间建立单向连接。
 * 中介者清除了发送者和请求者之间的直接连接， 强制它们通过一个中介对象进行间接沟通。
 * 观察者允许接收者动态地订阅或取消接收请求。
 * 源码中的使用：
 * 各类源码中的filter基本都使用了责任链模式。比如servlet，tomcat，spring都有
 * 个人理解：
 * 学习责任链模式对阅读源码有很大帮助，基本各类框架，中间件都有在使用。
 * 日常开发中，如果能准确识别到场景，
 * 可以试着使用（毕竟减少了大量的if,else）。
 * 所谓的准确场景，个人理解。就是有一堆处理者要对某个对象在真正进行它的主流程之前
 * 进行处理。在我们代码例子中主流程其实就是study.study()方法。辅助流程就是washFaceFilter,WashHairFilter等。并且这些
 * 辅助流程能抽象出共同的操作（对对象的统一处理，代码中的prepare方法）。
 * <p>
 * 责任链模式分为两种：
 * 1. 标准的责任链：
 * 1.1 一个具体的处理者对象只能在两个行为中选择一个：一是承担责任，二是把责任推给下家。
 * 不允许出现某一个具体处理者对象在承担了一部分责任后又 把责任向下传的情况。
 * 1.2 一个请求必须被某一个处理者对象所接收。
 * 2.非标准的责任链：
 * 一个请求可以最终不被任何接收端对象所接收
 * 但现在的实际情况中，大部分源码中使用的都是非标准的责任链（增加了一个filterChain类来管理各种filter,
 * 在各种filter中做完处理后，再次调用dofilter方法）。其实这正式印证了设计模式的初衷。
 * "它不是一个可以直接转换成源代码的设计，只是一套在软件系统设计过程中程序员应该遵循的最佳实践准则。"
 *
 */
public class Client {
    public static void main(String[] args) {
        //初级版本。这样对调用方不够优雅
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);

        Study study = new Study();

        AbstractPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter(null);
        AbstractPrepareFilter washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
        AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);

        washHairFilter.doFilter(preparationList, study);
        //最终版本。源码中都是这种方式。用一个filterChain来管理。（其实就是组合模式+责任链模式。
        // filterChain为composite类。具体filter为leaf类。具体工作都是交给leaf类做）
        PreparationList list = new PreparationList();
        list.setWashFace(true);
        list.setWashHair(false);
        list.setHaveBreakfast(true);

        Study study1 = new Study();

        StudyPrepareFilter washFaceFilter1 = new GeneralWashFaceFilter();
        StudyPrepareFilter washHairFilter1 = new GeneralWashHairFilter();
        StudyPrepareFilter haveBreakfastFilter1 = new GeneralHaveBreakfastFilter();

        FilterChain filterChain = new FilterChain(study1);
        filterChain.addFilter(washFaceFilter1);
        filterChain.addFilter(washHairFilter1);
        filterChain.addFilter(haveBreakfastFilter1);

        filterChain.doFilter(list, filterChain);
    }
}
