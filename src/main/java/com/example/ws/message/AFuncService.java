package com.example.ws.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AFuncService implements IAFuncService{
    @Override
    public void login() {
        log.info("[{}]抛出登录事件 ... ", this.getClass());
        //EventContainer.submit(LoginEvent.class);
    }

}
