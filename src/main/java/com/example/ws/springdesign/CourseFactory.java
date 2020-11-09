package com.example.ws.springdesign;

import java.util.Objects;

public class CourseFactory {
    public ICourse create(String name){
        try {
            if(Objects.nonNull(name)){
               return  (ICourse) Class.forName(name).newInstance();
            }
        }catch (Exception e){
            System.out.println("出错了");
        }
        return null;
    }

    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create("com.example.ws.springdesign.JavaCourse");
        course.record();
    }
}
