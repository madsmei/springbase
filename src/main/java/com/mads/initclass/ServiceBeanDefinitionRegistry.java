package com.mads.initclass;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @Description: 用于Spring动态注入bean接口
 *
 * 所有实现了BeanDefinitionRegistryPostProcessor接口的bean，
 * 其postProcessBeanDefinitionRegistry方法都会调用，然后再调用其postProcessBeanFactory方法，
 * 这样一来，我们如果自定义了BeanDefinitionRegistryPostProcessor接口的实现类，
 * 那么我们开发的postProcessBeanDefinitionRegistry和postProcessBeanFactory方法都会被执行一次
 * @Date 2020/4/14
 * @Version V1.0
 * @Author Mads
 **/
public class ServiceBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    /*****
     * 该方法用来注册更多的bean到spring容器中，详细观察入参BeanDefinitionRegistry接口
     * BeanDefinitionRegistry提供了丰富的方法来操作BeanDefinition，判断、注册、移除等方法都准备好了，我们在编写postProcessBeanDefinitionRegistry方法的内容时，就能直接使用入参registry的这些方法来完成判断和注册、移除等操
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //这个方法先执行
    }

    /*****
     * 该方法的实现中，主要用来对bean定义做一些改变。
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //然后再执行此方法
    }
}
