package com.mads.aop;

import com.mads.annotation.TargetSource;
import com.mads.druidconfig.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/******
 * @Description: 多数据源 用于处理链接字符串的AOP
 * 相关三个类 {@link TargetSource,com.mads.druidconfig.DynamicDataSource,DynamicDataSourceHolder}
 * 测试类在 {@link com.mads.service.UserServiceImpl#queryUser(String)}
 * @Date 2020/3/28
 * @Version V1.0
 * @Author Mads
 **/
@Component
@Aspect
/*
 *要优先于事务执行
 * */
@Order(-1)
public class AspectDS {

    /****
     * 利用环绕通知。来处理 TargetSource定义注解的 逻辑
     *
     * @param joinPoint
     * @param targetSource
     * @return
     */
    @Around(value = "@annotation(targetSource)")
    public Object choiseDs(ProceedingJoinPoint joinPoint, TargetSource targetSource) {
        System.out.println("==========AspectDs============");

        String value = targetSource.value();

        //如果 设置了数据源就用设置的，没设置就用默认的
        if(value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

}
