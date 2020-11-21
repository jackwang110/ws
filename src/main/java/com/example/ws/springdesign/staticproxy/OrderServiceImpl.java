package com.example.ws.springdesign.staticproxy;

public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;

    public OrderServiceImpl(){
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}
