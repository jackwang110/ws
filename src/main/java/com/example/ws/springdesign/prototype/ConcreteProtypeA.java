package com.example.ws.springdesign.prototype;

import java.util.List;

public class ConcreteProtypeA implements Prototype{
    private int age;
    private String name;
    private List hobbies;


    @Override
    public Prototype clone() {
        ConcreteProtypeA protypeA = new ConcreteProtypeA();
        protypeA.setAge(age);
        protypeA.setName(name);
        protypeA.setHobbies(hobbies);
        return protypeA;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }
}
