package com.mads.mvc.test;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String queryUser(String userId) {
        return "return =========UserServiceImpl.queryUser";
    }
}
