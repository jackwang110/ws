package com.example.ws.design.singleton;



public class Single {
    private volatile static  Single single;
    private Single(){}
    public static Single getSingle(){
        if(single == null){
            synchronized(Single.class){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}
