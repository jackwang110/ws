package com.example.ws.springdesign.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    // 被代理的对象，把引用保存下来
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target,args);
        after();
        return object;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你物色对象，现在已经确认你的要求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("如何有合适的准备办事");
    }
}
