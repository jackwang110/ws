package com.example.ws.design.singleton;

public class Singleton {
    /*private static Singleton singleton = new Singleton();
    private Singleton(){

    }
    public static Singleton getSingleton(){
        return singleton;
    }*/
    private static Singleton singleton = null;

    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized  (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
