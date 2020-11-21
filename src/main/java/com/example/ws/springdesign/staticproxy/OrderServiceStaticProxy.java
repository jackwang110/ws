package com.example.ws.springdesign.staticproxy;

public class OrderServiceStaticProxy {
    public final static String DEFEAULT_SOURCE = null;

    public final static ThreadLocal<String> local = new ThreadLocal<String>();

    public static void clear(){
        local.remove();
    }

    public static String get(){
       return local.get();
    }

    public static void restore(){
        local.set(DEFEAULT_SOURCE);
    }

    public static void set(String dataSource){
        local.set(dataSource);
    }
    public static void set(int year){
        local.set("DB" + year);
    }
}
