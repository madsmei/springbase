package com.mads;

import com.mads.bean.Account;
import com.mads.bean.Lannister;
import com.mads.bean.Student;
import com.mads.initclass.InitClassAfter;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*****
 * 使用AnnotationConfigApplicationContext可以实现基于Java的配置类（包括各种注解）加载Spring的应用上下文
 */
public class SpringbaseApplicationTests {


    @Test
    public void test2() {
        //告诉山下文 帮我把com.mads.bean目录下的bean加载出来。注意 该目录下 必须是使用了类似@Component注解，否则Spring根本不鸟你
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");
        /****
         *下面至于为什么要加&，加与不加的区别请看 {@link com.mads.initclass.FactoryBeanClass}
         */
        //        System.out.println("-1-->"+applicationContext.getBean("factoryBeanClass"));
        System.out.println("-1-->"+applicationContext.getBean("&factoryBeanClass"));
        System.out.println("-2-->"+applicationContext.getBean(InitClassAfter.class));

        System.out.println("-3-->"+applicationContext.getBean(Lannister.class).toString());
        System.out.println("-4-->"+applicationContext.getBean(Account.class));
    }

}
