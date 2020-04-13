package com.mads.test;

import com.mads.bean.Account;
import com.mads.bean.Lannister;
import com.mads.entity.ConsultConfigArea;
import com.mads.initclass.InitClassAfter;
import com.mads.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Description: 使用AnnotationConfigApplicationContext可以实现基于Java的配置类（包括各种注解）加载Spring的应用上下文
 *  * 调用里面的 refresh（）方法 启动Spring容器，spring一切的启点，，
 * @Date 2020/4/5
 * @Version V1.0
 * @Author Mads
 **/
@Slf4j
@WebAppConfiguration
@ContextConfiguration
public class Mytest {

    @Test
    public void test2() {
        //告诉山下文 帮我把com.mads.bean目录下的bean加载出来。注意 该目录下 必须是使用了类似@Component注解，否则Spring根本不鸟你
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");
        /****
         *下面至于为什么要加&，加与不加的区别请看 {@link com.mads.initclass.FactoryBeanClass}
         */
        System.out.println("-1-->"+applicationContext.getBean("factoryBeanClass"));
        System.out.println("-1-->"+applicationContext.getBean("&factoryBeanClass"));
        System.out.println("-2-->"+applicationContext.getBean(InitClassAfter.class));

        System.out.println("-3-->"+applicationContext.getBean(Lannister.class).toString());
        System.out.println("-4-->"+applicationContext.getBean(Account.class));
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{

                if (finalI % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                } else {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                }

            }).start();
        }

        try {
            //阻塞主线程，不然你懂的，noting
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*****
     * 测试 插入数据库
     */
    @Test
    public void test4() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");
        UserService bean = applicationContext.getBean(UserService.class);

        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("HB");
        area.setAreaName("HB");
        area.setState("1");
        String cacheResult = bean.addArea(area);

//        log.info(Thread.currentThread().getName() + "========" + cacheResult);
    }

    @Test
    public void test5(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");

    }
}
