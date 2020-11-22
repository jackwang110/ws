package com.example.ws.springdesign.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }




    private void before(Object target){
        System.out.println("代理方法之前");
        try {
            Long createTime = (Long)target.getClass().getMethod("getCreateTime").invoke(target);
            Integer value = Integer.valueOf(dateFormat.format(new Date(createTime)));
            System.out.println("代理过程中");
            DynamicDataSourceEntry.set(value);

        } catch (Exception e) {
            e.printStackTrace();
       }
    }
    private void after(){
        System.out.println("代理之后");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object o = method.invoke(proxy, args);
        after();
        return o;
    }
}
