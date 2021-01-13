package com.mads.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * @Description: 这个是注解的方式  。另外一种 请看 {@link MyApplicationListener}
 * <p>
 * ps:需要 配置异步事件通道。如果不设置还是同步的。也就不是真正的发布订阅模式了。
 * @Date 2020/4/25
 * @Version V1.0
 * @Author Mads
 **/
public class EventListenerDeomo {

    class TestObject {
        private Long id;
        private String name;
    }

    @Autowired
    private ApplicationContext context;


    public void doString(TestObject c) {
        //do

        //发布事件
        context.publishEvent(c);
    }


    class EventListerDo {
        /****
         * 监听 事件，并处理
         * @param c
         */
        @EventListener
        public void doString(TestObject c) {
            System.out.println("监听到事件 " + c.id + " " + c.name);
        }
    }
}
