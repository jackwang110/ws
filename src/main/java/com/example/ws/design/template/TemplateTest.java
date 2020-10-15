package com.example.ws.design.template;

public class TemplateTest {
    public static void main(String[] args) {
        CommonMode fish = new Fish();
        CommonMode person = new Person();
        fish.breathe("鳃");
        person.breathe("肺");
    }
}
