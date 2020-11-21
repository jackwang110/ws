package com.example.ws.springdesign.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceProxy extends OrderServiceImpl{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");

    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        long time = order.getCreateTime();
        Integer dbRout = Integer.valueOf(dateFormat.format(new Date(time)));
        OrderServiceStaticProxy.set(dbRout);
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

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            Date date = format.parse("2020/01/01");
            order.setCreateTime(date.getTime());
            OrderService orderService = new OrderServiceProxy(new OrderServiceImpl());
            orderService.createOrder(order);
        }catch (Exception e){

        }
    }
}
