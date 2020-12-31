package com.mads;

import com.mads.bean.Account;
import com.mads.bean.Lannister;
import com.mads.entity.ConsultConfigArea;
import com.mads.initclass.InitClassAfter;
import com.mads.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/*****
 *
 */
@Slf4j
public class SpringbaseApplicationTests {

    @Test
    public void test1() {
        //告诉山下文 帮我把com.mads.bean目录下的bean加载出来。注意 该目录下 必须是使用了类似@Component注解，否则Spring根本不鸟你
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.mads");
    }
}
