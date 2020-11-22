package com.example.ws.springdesign.dynamicproxy;

public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService(){
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("orderService 调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
