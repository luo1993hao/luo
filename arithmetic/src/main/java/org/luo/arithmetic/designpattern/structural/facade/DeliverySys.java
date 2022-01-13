package org.luo.arithmetic.designpattern.structural.facade;

//物流系统
public class DeliverySys {
    public int getDeliveryTime() {
        System.out.println("获取配送耗时");
        return 30 * 60;//30分钟
    }
}
