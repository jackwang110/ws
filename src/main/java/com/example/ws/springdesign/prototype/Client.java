package com.example.ws.springdesign.prototype;

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype prototype1){
        return (Prototype)prototype1.clone();
    }
}
