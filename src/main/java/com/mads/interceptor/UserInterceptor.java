package com.mads.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*****
 * 拦截器
 * 步骤
 *    1.实现接口，编写拦截代码
 *    2.注册到 Spring中， {@link com.mads.mvc.AppConfig#addInterceptors(InterceptorRegistry)}
 *
 * 如果是多个拦截器，可是配置@Order注解调整他们的优先级，控制执行顺序
 */
@Order(1)
@Component
public class UserInterceptor implements HandlerInterceptor {

    /*
    * 前置拦截器，是优先执行的（看门狗）
    * 用来控制  要不要把请求往下执行，
    *
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========UserInterceptor.preHandle==========");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========UserInterceptor.postHandle==========");
    }

    /*****
     * 后置烂机器
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========UserInterceptor.afterCompletion==========");
    }
}
