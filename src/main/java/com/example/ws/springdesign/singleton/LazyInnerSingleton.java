package com.example.ws.springdesign.singleton;

public class LazyInnerSingleton {
    private LazyInnerSingleton(){
        if(InnerSingle.LAZY != null){
            throw new RuntimeException("已经创建实例");
        }
    }

    public static final LazyInnerSingleton getInstance(){
        return InnerSingle.LAZY;
    }
    private static class InnerSingle{
        private static final LazyInnerSingleton LAZY = new LazyInnerSingleton();
    }
}
