package com.example.ws.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BFuncService implements IBFuncService {

   // @ReceiveAnno(clz = LoginEvent.class)
    private void doAfterLogin() {
        log.info("[{}]监听到登录事件 ... ", this.getClass());
    }


}
