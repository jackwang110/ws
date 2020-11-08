package com.example.ws.design.srp;

public class Course {
    public void Study(String courseName){
        if("直播课".equals(courseName)){
            System.out.println(courseName+"不能快进");
        }else {
            System.out.println(courseName+"可以反复观看");
        }
    }

    public static void main(String[] args) {
        Course course = new Course();
        course.Study("直播课");
    }
}
