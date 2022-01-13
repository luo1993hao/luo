package org.luo.arithmetic.designpattern.structural.facade;

public class ReportFacade {

    public void generateReport() {
        OrderSys orderSys = new OrderSys();
        PaymentSys paymentSys = new PaymentSys(orderSys);
        DeliverySys deliverySys = new DeliverySys();

        final String orderNum = orderSys.getOrderNum();
        System.out.printf("\n报表\n--------------------------------------------\n" +
                        "订单号：%s | 金额：%s元 | 配送耗时：%s分钟%n",
                orderNum,
                paymentSys.getOrderAccount(orderNum).toPlainString(),
                deliverySys.getDeliveryTime() / 60);
    }
}
