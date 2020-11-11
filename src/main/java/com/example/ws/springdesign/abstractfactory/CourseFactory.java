package com.example.ws.springdesign.abstractfactory;

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
