package com.mads.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Description: 告诉spring帮我把AOP功能启动
 * @Date 2020/3/28
 * @Version V1.0
 * @Author Mads
 **/
@Component
@EnableAspectJAutoProxy
public class EnableAspectJAutoProxyBean {
}
