package com.example.ws.design.dip;

public class Tom {
  /*  public void studyJavaCource(){
        System.out.println("Tom在学习JAVA课程");
    }
    public void studyPythonCource(){
        System.out.println("TOM在学习python课程");
    }

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.studyJavaCource();
        tom.studyPythonCource();
    }*/
  /*public void study(ICource cource){
      cource.study();
  }*/
  private ICource cource;

  /*public Tom(ICource cource){
       this.cource = cource;
  }*/
  public void setCourse(ICource cource){
      this.cource = cource;
  }
  public void study(){
      cource.study();
  }

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();
    }
}
