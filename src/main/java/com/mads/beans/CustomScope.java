package com.mads.beans;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *  一般我们加上@Component 注解，就是把类交给spring帮我们管理，如果我们想自己管理怎么办呢
 * Scope 接口就是把这个控制权交给我们自己，不过这个接口的使用场景并不是很多。scope管理的bean 是不会进入 Spring的一级缓存的
 * <p>
 * 步骤：
 * 1.继承接口
 * 2.实现必要方法
 * 3.将自己的scope注册到spring,这样才能被调用 {@link ServiceBeanDefinitionRegistry#postProcessBeanFactory}
 * 4.在需要自己管理的bean上加上@Score("customScope"),
 * <p>
 * 注意：
 * 1.Scope管理是 调用toString()方法，如果你重写了，可能会造成 Scope管理出现神奇的问题,哈哈哈
 * <p>
 * 场景：
 * 1.例如SpringCloud中的Springbus消息总线，吧远程的配置刷新到本地
 **/
public class CustomScope implements Scope {

    //这里使用ThreadLocal 是为了每个线程拿到的都是自己的。也可以换成其他容器
    private ThreadLocal local = new ThreadLocal();


    /******
     * 这个就是我们管理 bean 的方式（步骤），使用到ThreadLocal 是在多线程环境下 每个人拿到的对象都是自己的
     */
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {

        System.out.println("-----自定义Scope执行了------");
        if (local.get() != null) {
            return local.get();
        } else {
            //创建实例
            Object object = objectFactory.getObject();
            local.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

