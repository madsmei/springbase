package com.mads.controllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description 统一的资源返回
 * @Author Mads
 * @Date 2020/5/29 13:39
 */
@RestControllerAdvice
@Slf4j
public class ResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果不需要拦截的，才返回false
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

//        if (null == o) {
//            return ResponseResource.SUCCESS;
//        }
//
//        //返回本身就是正确的结构，直接返回
//        if (o instanceof ResponseResource) {
//            return (ResponseResource<Object>) o;
//        }
//        // string 特殊处理
//        if (o instanceof String) {
//            return JsonUtil.toJson(ResponseResource.create(o)).get();
//        }
//        ResponseResource resource = ResponseResource.create(o);
//        log.trace("" + resource.toString());
//
//        //一个request结束，清掉ThreadLocal
//        ThreadLocalUtil.reset();
//
//        return resource;
        return null;
    }
}
