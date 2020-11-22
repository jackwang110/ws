package com.example.ws.springdesign.dynamicproxy;

import com.example.ws.springdesign.proxy.Person;

public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180");
        System.out.println("有6块腹肌");
    }

    public static void main(String[] args) {
        try {
            Person person = (Person)new JDKMeipo().getInstance(new Customer());
            person.findLove();
        }catch (Exception e){

        }
    }
}
