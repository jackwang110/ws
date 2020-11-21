package com.example.ws.springdesign.staticproxy;

public class OrderDao {
    public int insert(Order order){
        System.out.println("插入订单");
        return 1;
    }

}
