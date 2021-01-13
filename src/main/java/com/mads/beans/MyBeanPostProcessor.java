package com.mads.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 如果它是第二，没有其他的敢说第一
 * * 他就是完成 我们搜集并封装的Definiton对象进行注册给spring容器
 * 这个接口在Spring源码中出现频率相当的高, 他在源码中各个环节都做了埋点，用来处理对应事情
 *
 * @Description: 该接口我们也叫后置处理器，作用是在Bean对象在实例化和依赖注入完毕后，
 * 在显示调用初始化方法的前后添加我们自己的逻辑。注意是Bean实例化完毕后及依赖注入完成后触发的。接口的源码如下
 * <p>
 * 注意：
 * 注意:接口中两个方法不能返回null，如果返回null那么在后续初始化方法将报空指针异常或者通过getBean()方法获取不到bena实例对象，
 * 因为后置处理器从Spring IoC容器中取出bean实例对象没有再次放回IoC容器中
 * <p>
 * 当类实例化后，都要经过这个接口的的各种子类去解析各种各样的注解并完成IOC注入完成初始化，
 *
 * 这个接口 是装饰器设计模式的应用
 *
 * @Date 2020/4/3
 * @Version V1.0
 * @Author Mads
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    /*****
     * 在Bean的自定义初始化方法之前执行
     *      * 	 * Bean对象已经存在了
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
     * 在Bean的自定义初始化方法执行完成之后执行
     *      * 	 * Bean对象已经存在了
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
