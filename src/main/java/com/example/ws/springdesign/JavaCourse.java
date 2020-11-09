package com.example.ws.springdesign;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("学习了java");
    }
}
