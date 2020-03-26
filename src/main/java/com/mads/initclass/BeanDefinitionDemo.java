package com.mads.initclass;

import com.mads.bean.Lannister;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Description: 这个是在类实例化之前被调用
 * 看懂此类的逻辑的关键在于要理解什么是BeanDefinition?
 *          它是spring的基础，一切罪恶的开端，以前使用xml的方式注册bean和现在使用@Component注解的方式注册bean
 *          spring在底层处理是 都是要把我们的类，转化成BeanDefinition对象，然后注册到spring容易，
 *          可以理解为 BeanDefinition对象就是spring在我们真正的类上加了一个壳，
 * 场景：
 *    1.资源的加载
 *    2.核心参数的生成
 *    3.数据预热
 * @Date 2020/3/27
 * @Version V1.0
 * @Author
 **/
@Component
public class BeanDefinitionDemo implements BeanDefinitionRegistryPostProcessor {

    /*****
     * @param beanDefinitionRegistry  BeanDefinition的注册器，可以简单把他当成个存放了BeanDefinition对象的map,就好理解了
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //获取到所有BeanDefinition对象的名字
        String[] beanDefinitionNames = beanDefinitionRegistry.getBeanDefinitionNames();

        for (String beanDefinitionName:beanDefinitionNames) {

            //当发现是student将要实例化之前，将Lannister类同时实例化出来
            if("student".equals(beanDefinitionName)) {
//                BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanDefinitionName);

                GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
                genericBeanDefinition.setBeanClass(Lannister.class);

                MutablePropertyValues propertyValues = genericBeanDefinition.getPropertyValues();

                propertyValues.add("name", "瑟曦");
                propertyValues.add("sex", "女");

                beanDefinitionRegistry.registerBeanDefinition("lannister", genericBeanDefinition);
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
