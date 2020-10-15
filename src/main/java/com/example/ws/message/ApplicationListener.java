package com.example.ws.message;

import java.util.EventListener;

public interface ApplicationListener<E extends ApplicationEventSimple>
        extends EventListener {
    void onApplicationEvent(E event);
}
