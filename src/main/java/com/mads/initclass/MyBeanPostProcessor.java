package com.mads.initclass;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 这个接口在Spring源码中出现频率相当的高
 * @Description: 该接口我们也叫后置处理器，作用是在Bean对象在实例化和依赖注入完毕后，
 * 在显示调用初始化方法的前后添加我们自己的逻辑。注意是Bean实例化完毕后及依赖注入完成后触发的。接口的源码如下
 *
 * 注意：
 * 注意:接口中两个方法不能返回null，如果返回null那么在后续初始化方法将报空指针异常或者通过getBean()方法获取不到bena实例对象，
 * 因为后置处理器从Spring IoC容器中取出bean实例对象没有再次放回IoC容器中
 * @Date 2020/4/3
 * @Version V1.0
 * @Author Mads
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    /*****
     * 实例化、依赖注入完毕，
     * 在调用显示的初始化之前完成一些定制的初始化任务
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    /******
     * 实例化、依赖注入、初始化完毕时执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

}
