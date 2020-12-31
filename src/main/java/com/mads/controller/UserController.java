package com.mads.controller;

import com.mads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/*****
 * 测试一下 我们的AOP是不是可以切换数据源
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /****
     * 查询用户
     * @param areaCode
     * @return
     */
    @RequestMapping("/queryUser")
    public @ResponseBody
    String queryUser(@RequestParam String areaCode) {
        return userService.queryUser(areaCode);
    }

    /*****
     * 测试 全局异常拦截
     * @return
     */
    @RequestMapping("/exceptionTest")
    public @ResponseBody
    String exceptionTest() {
        String aa = null;
        aa.substring(0);

        return aa;
    }
}
