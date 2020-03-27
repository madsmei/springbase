package com.mads.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
/*****
 *我们的Spring中其实有两个容器，springmvc容器 {@link MvcContainer} 和spring容器 {@link SpringContainer}
 * springmvc容器是spring容器的子类
 *
* 约定大于配置
* 1、创建HandlerMapping
* 2、创建HandlerAdapter
* 3、创建视图解析
* 4、创建消息转换器
* 。。。。。。。
*
* 这个注解  把springmvc的功能，给我加上来
* */
@EnableWebMvc
public class AppConfig {
}
