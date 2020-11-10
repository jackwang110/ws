package com.example.ws;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class JavaTest {
    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));
        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));


    }

    public static void displayObjectClass(Object o){
        if (o instanceof Vector){
            System.out.println("对象是 java.util.Vector 类的实例"); }
        else if (o instanceof ArrayList) {
            System.out.println("对象是 java.util.ArrayList 类的实例"); }
        else {
            System.out.println("对象是 " + o.getClass() + " 类的实例");}
        }
}
