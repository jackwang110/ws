package com.example.ws.springdesign.dynamicproxy;

public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建订单");
        return 1;
    }

}
