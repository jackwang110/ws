package com.example.ws.design.opc;

public class JavaCourse implements ICourse{
    private Integer Id;
    private String name;
    private Double price;

    public JavaCourse(Integer id,String name,Double price){
            this.Id = id;
            this.name = name;
            this.price = price;
    }
    @Override
    public Integer getId() {
        return Id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
