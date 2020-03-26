package com.mads.initclass;

import com.mads.bean.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description: 一个类对应着一个bean类
 *  注意：
 *      当根据factoryBeanClass该类时，spring会调用getObject()方法返回一个我们事先写好的类的对象实例。有点像是代理的意思，
 *      因此context.getBean("factoryBeanClass") 获取的是student对象，并不是FactoryBeanClass本身，
 *      如果想要获取FactoryBeanClass本身可以这样context.getBean("@factoryBeanClass")
 *
 *
 *  场景：
 * @Date 2020/3/27
 * @Version V1.0
 * @Author Mads
 **/
@Component("factoryBeanClass")
public class FactoryBeanClass implements FactoryBean {

    /*****
     * 返回一个对象实例
     * 例如当上下文获取bean实例时，spring就会调用此方法返回一个对象实例
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
