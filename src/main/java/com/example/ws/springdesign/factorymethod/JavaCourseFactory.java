package com.example.ws.springdesign.factorymethod;

import com.example.ws.springdesign.ICourse;
import com.example.ws.springdesign.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
