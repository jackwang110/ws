package com.example.ws.springdesign.staticproxy;

public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建订单");
        return 1;
    }

}
