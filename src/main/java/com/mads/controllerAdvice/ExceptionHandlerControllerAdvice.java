package com.mads.controllerAdvice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description: controller的全局异常拦截,只拦截.mads包下的，
 * 为什么要有全局拦截呢，就是为了统一处理异常信息，让用户更友好，总不能让用户看到 500，这类的异常
 *
 * 这里我们可以只写一个，只要是异常就返回一个固定的提示信息，用户才不管你是下标越界还是空指针。。。
 * @Date 2020/3/28
 * @Version V1.0
 * @Author Mads
 **/
@ControllerAdvice("com.mads")
public class ExceptionHandlerControllerAdvice {


    /*****
     * 处理下标越界 异常
     * @param e
     * @return
     */
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    public @ResponseBody
    String handlerArrayIndexOutOfBoundsException(Exception e){
        System.out.println("===========ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "{'errormsg':'handlerArrayIndexOutOfBoundsException'}";
    }

    /****
     * 处理空指针异常，
     * @param e
     * @return
     */
    @ExceptionHandler({NullPointerException.class})
    public @ResponseBody
    String handlerNullPointerException(Exception e) {
        System.out.println("===========ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "handlerNullPointerException";
    }

}
