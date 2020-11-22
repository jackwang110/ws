package com.example.ws.springdesign.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        long time = order.getCreateTime();
        Integer dbRout = Integer.valueOf(dateFormat.format(new Date(time)));
        DynamicDataSourceEntry.set(dbRout);
        System.out.println("静态代理类自动分配到");
        orderService.createOrder(order);
        after();
        return 0;
    }
    private void before(){
        System.out.println("代理之前");
    }
    private void after(){
        System.out.println("代理之后");
    }


}
