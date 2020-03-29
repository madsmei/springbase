package com.mads.service;

import com.mads.entity.ConsultConfigArea;

/*****
 * y用户服务
 */
public interface UserService {
    String queryUser(String userId);

    String addArea(ConsultConfigArea area);
}
