package com.mads.initclass;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description: beanPostProcessor 如果它是第二，没有其他的敢说第一
 * 他就是完成 我们搜集并封装的Definiton对象进行注册给spring容器
 * @Date 2020/4/5
 * @Version V1.0
 * @Author Mads
 **/
public class BeanPostProcessorDemo implements BeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return null;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return null;
//    }
}
