package com.example.ws;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class JavaTest {
    public static void main(String[] args) throws Exception{
/*        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));
        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));*/
        LocalDateTime time = LocalDateTime.now().plusDays(Long.valueOf(10));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = time.format(format);
        getPlusDate(10,LocalDateTime.now());
        Map<Object, Object> map = new HashMap<>();
        String str = "a,b,c, ,";
        String[] split = str.split(",");
        System.out.println(split.length);
       new  CopyOnWriteArrayList();
       new Vector<>();
       Collections.synchronizedList(new ArrayList<>());
       Collections.synchronizedList(new LinkedList<String>());
    }

    public static void displayObjectClass(Object o){
        if (o instanceof Vector){
            System.out.println("对象是 java.util.Vector 类的实例"); }
        else if (o instanceof ArrayList) {
            System.out.println("对象是 java.util.ArrayList 类的实例"); }
        else {
            System.out.println("对象是 " + o.getClass() + " 类的实例");}
        }
    public static String getPlusDate(int num, LocalDateTime localDateTime){
        LocalDateTime time = localDateTime.plusDays(Long.valueOf(num));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = time.format(format);
        System.out.println(s);
        return s;
    }
}
