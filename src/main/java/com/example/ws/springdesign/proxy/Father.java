package com.example.ws.springdesign.proxy;

public class Father {
    private Son son;

    public Father(Son son){
        this.son = son;
    }

    public void findLove(){
        System.out.println("父亲物色对象");
        this.son.findLove();
        System.out.println("双方同意交易，在一起");
    }

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
