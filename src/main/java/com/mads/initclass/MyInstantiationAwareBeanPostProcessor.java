package com.mads.initclass;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @Description: InstantiationAwareBeanPostProcessor接口主要作用在于目标对象的实例化过程中需要处理的事情，
 * 包括实例化对象的前后过程以及实例的属性设置
 * @Date 2020/4/14
 * @Version V1.0
 * @Author Mads
 **/
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /*****
     * 这个方法最先执行。
     *InstantiationAwareBeanPostProcessor中自定义的方法
     * 	 * 在方法实例化之前执行  Bean对象还没有
     *
     * 	 该方法返回的结果如果为null,后面的方法都正常执行了，但是如果该方法返回了实例对象了
     * 	 通过数据结果我们发现，postProcessBeforeInstantiation方法返回实例对象后跳过了对象的初始化操作，
     * 	 直接执行了postProcessAfterInitialization(该方法在自定义初始化方法执行完成之后执行)，
     * 	 跳过了postProcessAfterInstantiation，postProcessPropertyValues以及自定义的初始化方法(start方法)
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /****
     * BeanPostProcessor接口中的方法
     * 	 * 在Bean的自定义初始化方法执行完成之后执行
     * 	 * Bean对象已经存在了
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }

    /******
     * InstantiationAwareBeanPostProcessor中自定义的方法 可以用来修改Bean中属性的内容
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }

    /*****
     * BeanPostProcessor接口中的方法
     * 	 * 在Bean的自定义初始化方法之前执行
     * 	 * Bean对象已经存在了
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    /****
     * BeanPostProcessor接口中的方法
     * 	 * 在Bean的自定义初始化方法执行完成之后执行
     * 	 * Bean对象已经存在了
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
