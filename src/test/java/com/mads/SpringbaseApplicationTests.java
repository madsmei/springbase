package com.mads;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
