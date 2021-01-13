package com.mads.beans;

import com.mads.bean.Lannister;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 用于Spring动态注入bean接口,（这个接口的方法在bean 完成硬盘扫描搜集 bean开始实例化之前调用。）
 * <p>
 * 所有实现了BeanDefinitionRegistryPostProcessor接口的bean，
 * 其postProcessBeanDefinitionRegistry方法都会调用，然后再调用其postProcessBeanFactory方法，
 * 这样一来，我们如果自定义了BeanDefinitionRegistryPostProcessor接口的实现类，
 * 那么我们开发的postProcessBeanDefinitionRegistry和postProcessBeanFactory方法都会被执行一次
 **/
public class ServiceBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    /*****
     * 该方法用来注册更多的bean到spring容器中，详细观察入参BeanDefinitionRegistry接口
     * BeanDefinitionRegistry提供了丰富的方法来操作BeanDefinition，判断、注册、移除等方法都准备好了，
     * 我们在编写postProcessBeanDefinitionRegistry方法的内容时，就能直接使用入参registry的这些方法来完成判断和注册、移除等操
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //这个方法先执行

        //获取到所有BeanDefinition对象的名字
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {

            //当发现是student将要实例化之前，将Lannister类同时实例化出来
            if ("student".equals(beanDefinitionName)) {
//                BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanDefinitionName);

                GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
                genericBeanDefinition.setBeanClass(Lannister.class);

                MutablePropertyValues propertyValues = genericBeanDefinition.getPropertyValues();

                propertyValues.add("name", "瑟曦");
                propertyValues.add("sex", "女");

                registry.registerBeanDefinition("lannister", genericBeanDefinition);
            }
        }

        /*
         * 自定义扫描器, 扫描使用了我们自定义注解的bean，装载成 BeanDefinition对象，所以一直强调。BeanDefinition是一切的基础
         * */
//        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
//        classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
//        classPathBeanDefinitionScanner.scan("com.mads");
    }

    /*****
     * 该方法的实现中，主要用来对bean定义做一些改变。
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //然后再执行此方法

        /****将我们的 {@link com.mads.bean.ScopeBean} 交给我们自己自定义管理****/
        beanFactory.registerScope("madsScope", new CustomScope());
    }
}
