package com.example.ws.springdesign.dynamicproxy;

public class DynamicDataSourceEntry {
    public final static String DEFEAULT_SOURCE = null;

    public final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntry(){}
    // 清空数据源
    public static void clear(){
        local.remove();
    }
    // 获取正在使用的数据源
    public static String get(){
       return local.get();
    }
    // 还原当前切换的数据源
    public static void restore(){
        local.set(DEFEAULT_SOURCE);
    }
    // 设置已知的数据源
    public static void set(String dataSource){
        local.set(dataSource);
    }
    // 根据动态年份设置数据源
    public static void set(int year){
        local.set("DB" + year);
    }
}
