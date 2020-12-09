package com.example.ws.springdesign.delegate;

public class IEmployeeB implements IEmplotee{
    @Override
    public void doing(String command) {
        System.out.println("B正在做"+command);
    }
}
