package com.example.ws.springdesign.factorymethod;

import com.example.ws.springdesign.ICourse;
import com.example.ws.springdesign.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }

    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
