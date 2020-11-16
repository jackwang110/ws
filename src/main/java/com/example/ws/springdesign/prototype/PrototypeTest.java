package com.example.ws.springdesign.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        ConcreteProtypeA protypeA = new ConcreteProtypeA();
        protypeA.setAge(15);
        protypeA.setName("原型");
        List hobbies = new ArrayList();
        protypeA.setHobbies(hobbies);
        System.out.println(protypeA);

        //创建client,准备开始克隆
        Client client = new Client(protypeA);

        ConcreteProtypeA prototype = (ConcreteProtypeA)client.startClone(protypeA);
        System.out.println(prototype);


        System.out.println("克隆引用地址："+prototype.getHobbies());
        System.out.println("原对象引用地址："+protypeA.getHobbies());
        System.out.println("引用地址比较："+(prototype.getHobbies()==protypeA.getHobbies()));


    }
}
