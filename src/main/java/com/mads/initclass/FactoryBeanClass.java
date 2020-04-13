package com.mads.initclass;

import com.mads.bean.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Description:
 *  注意：
 *      当根据factoryBeanClass该类时，spring会调用getObject()方法返回一个我们事先写好的类的对象实例。有点像是代理的意思，
 *      因此context.getBean("factoryBeanClass") 获取的是student对象，并不是FactoryBeanClass本身，
 *      如果想要获取FactoryBeanClass本身可以这样context.getBean("@factoryBeanClass")
 *
 * 场景：
 *      1.使用代理生成对象实例
 *
 *  场景：
 * @Date 2020/3/27
 * @Version V1.0
 * @Author Mads
 **/
//@Component("factoryBeanClass")
public class FactoryBeanClass implements FactoryBean {

    /*****
     * 返回一个对象代理实例，
     *
     * 注意：通过源码发现，在Spring调用此方法之前，已经完成了该类的初始化，也放入了一级缓存。
     * 使用到了 装饰者模式
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        Student student = new Student();
        student.setUsername("提利昂·兰尼斯特");
        student.setPassword("听我怒吼");


        return student;
    }

    /*****
     * 返回对象的类型。。。
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
