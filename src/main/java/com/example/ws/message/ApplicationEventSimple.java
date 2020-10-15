package com.example.ws.message;

import org.springframework.context.ApplicationEvent;

public class ApplicationEventSimple extends ApplicationEvent {

    public ApplicationEventSimple(Object source) {
        super(source);
    }
}
