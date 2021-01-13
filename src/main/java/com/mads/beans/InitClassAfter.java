package com.mads.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 测试 类在实例化之前调用。
 * 这个类使用了@component注解，就是告诉spring我是一个bean，快来初始化我，这个里面我们还可以有我们自己的业务方法
 * 测试类请看 {@link com.mads.springbaseapplicationTests}
 * @Date 2020/3/27
 * @Version V1.0
 * @Author Mads
 **/
@Component
public class InitClassAfter implements InitializingBean, DisposableBean {

    private int a = 1;
    private int b = 1;

    //伪代码    我们自己的业务逻辑
    public void addNum() {
        System.out.println("计算结果：" + (a + b));
    }

    /*
     * 实现接口必须要实现的方法，
     * 目的：
     *      当前类实例化完成后调用
     *
     * 使用场景：
     *          1.做资源加载
     *          2.做日志打印
     *          3.做xml解析
     *          4.配置文件的加载
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----在InitClassAfter类实例化完成后调用了afterPropertiesSet方法------");

        addNum();
    }


    /******
     * 此注解的作用 和实现InitializingBean接口并实现上面方法的是一模一样的，
     *  区别：
     *      1.使用该注解的方法比上面的方式要提前那么一点
     *      2.代码侵入性比上面的方式要低
     *      3.不是spring源码提供的
     */
    @PostConstruct
    public void afterPropertiesSetByPostConstruct() {
        System.out.println("----在InitClassAfter类实例化完成后调用了afterPropertiesSetByPostConstruct方法------");
    }

    /*****
     * bean销毁，此方法会在源码中，初始化时在放入一级缓存之前自动加上
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {

    }
}
