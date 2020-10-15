package com.example.ws.design.template;

public abstract class ParentClass {
    //定义抽象方法
    abstract void learn(String name);
    //抽象父类的构造器
    ParentClass(){
        System.out.println("父类无参构造器被调用！");
    }
    {
        System.out.println("实例初始化块被调用！");
    }
    static{
        System.out.println("类初始化块被调用！");
    }
    //定义内部类(下面会讲到)
    class A{
    }
    //定义普通方法
    public void info(){
        System.out.println("抽象父类中的info方法被调用！");
    }
}
