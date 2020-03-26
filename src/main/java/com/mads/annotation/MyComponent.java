package com.mads.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解
 * @Date 2020/3/27
 * @Version V1.0
 * @Author Mads
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyComponent {
    /****
     * 注解的默认值
     * @return
     */
    String value() default "";
}
