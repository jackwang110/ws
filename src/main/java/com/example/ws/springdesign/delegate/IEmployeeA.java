package com.example.ws.springdesign.delegate;

public class IEmployeeA implements IEmplotee{
    @Override
    public void doing(String command) {
        System.out.println("A正在做"+command);
    }
}
