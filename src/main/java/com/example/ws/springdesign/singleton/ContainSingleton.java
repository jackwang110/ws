package com.example.ws.springdesign.singleton;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainSingleton {
    private ContainSingleton(){}

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        if(!ioc.containsKey(className)){
            Object obj = null;
            try {
                Class clazz = Class.forName(className);
                Constructor c = clazz.getDeclaredConstructor();
               obj=  c.newInstance();

            }catch (Exception e){
                e.printStackTrace();
            }
            return obj;
        }else {

            return ioc.get(className);
        }

    }
}
