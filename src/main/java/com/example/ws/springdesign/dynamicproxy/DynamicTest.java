package com.example.ws.springdesign.dynamicproxy;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DynamicTest {
    public static void main(String[] args) throws Exception{
        Order order = new Order();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse("2020/01/01");
        order.setCreateTime(date.getTime());
        IOrderService iOrderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
        iOrderService.createOrder(order);
    }
}
