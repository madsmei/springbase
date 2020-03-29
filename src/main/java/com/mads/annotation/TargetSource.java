package com.mads.annotation;

import java.lang.annotation.*;


/******
 * 用于处理多数据源 URL的自定义注解，使用AOP的方式 扫描注解并处理
 * 请阅读  {@link com.mads.aop.AspectDS}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface TargetSource {
    String value() default "ds1";
}
