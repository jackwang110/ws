package com.example.ws.message;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
@Component
public class EventProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        ReflectionUtils.doWithLocalMethods(bean.getClass(), new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {

                ReceiveAnno anno = method.getAnnotation(ReceiveAnno.class);
                if (anno == null) {
                    return;
                }

                Class clz = anno.clz();
                try {
                    if (!IEvent.class.isInstance(clz.newInstance())) {
                        FormattingTuple message = MessageFormatter.format("{}没有实现IEvent接口", clz);
                        throw new RuntimeException(message.getMessage());
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                EventContainer.addEventToMap(clz, method, bean);
            }
        });

        return super.postProcessAfterInstantiation(bean, beanName);
    }

}
