package com.example.ws.springdesign;

import java.util.Objects;

public class EazyCourseFactroy {
    public ICourse createClass(Class<? extends ICourse> clazz){
        try {
            if(Objects.nonNull(clazz)){
                return clazz.newInstance();
            }
        }catch (Exception e){
            System.out.println("出错了");
        }
        return null;
    }
    public static void main(String[] args) {
        EazyCourseFactroy factory = new EazyCourseFactroy();
        ICourse course = factory.createClass(JavaCourse.class);
        course.record();
    }
}
