package com.example.ws.design.template;

public class SubClass extends ParentClass{
    //当执行这个方法时，会调用抽象父类的构造器
    public SubClass(){}
    @Override
    void learn(String name) {
        System.out.println("我在学习"+name);
    }
    public void test(){
        System.out.println("子类test方法被调用！");
    }
    public static void main(String[] args) {
        //说明：new SubClass()会创建一个SubClass类的对象存放在堆内存中,
        //并让pc这个引用变量指向这个刚创建的对象,这个就是我们常听到的父类引用指向子类对象。
        //当我们只写new SubClass(); 来创建子类对象,我们从打印语句中我们可以看到：父类无参构造器被调用！
        //这说明父类构造器主要是提供其子类的构造器调用
        ParentClass pc=new SubClass();
        //因为子类的实例完全可以当成父类的对象使用,并且子类SubClass重写了抽象父类的learn方法,所以当然可以调用
        pc.learn("Java");
        pc.info();
        //当我们写pc.test();我们会看到编译器会报错，因为抽象父类ParentClass中根本没有test方法被定义
    }
}
