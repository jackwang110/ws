package com.example.ws.springdesign.abstractfactory;

public class JavaFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    public static void main(String[] args) {
        JavaFactory factory = new JavaFactory();
        factory.createNote();
        factory.createVideo();
    }
}
