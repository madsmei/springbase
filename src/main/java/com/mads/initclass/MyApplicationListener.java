package com.mads.initclass;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description: 当spring启动以后执行的逻辑，
 *              @EventListener注解也能达到相同的效果， 请看 {@link EventListenerDeomo}
 * @Date 2020/4/15
 * @Version V1.0
 * @Author Mads
 **/
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
