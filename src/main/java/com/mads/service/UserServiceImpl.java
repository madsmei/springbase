package com.mads.service;

import com.alibaba.fastjson.JSONObject;
import com.mads.annotation.TargetSource;
import com.mads.dao.CommonMapper;
import com.mads.entity.ConsultConfigArea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CommonMapper commonMapper;

    /****
     * @Cacheable 注解执行流程
     *  1、判断缓存有没有
     * 2、如果没有调用业务方法查询数据库
     * 3、把数据库返回的值加入到缓存
     *
     * @Cacheable缓存注解对应的配置请看 {@link com.mads.cache.CacheBean}
     *
     * 注意：@CachePut注解是没有上面1步骤的，每次都会查数据库然后加到缓存
    * */
//    @CachePut
    @Cacheable(cacheNames = "mapCache",key = "'user:' + #areaCode")
    @TargetSource("ds2")
    @Transactional
    @Override
    public String queryUser(String areaCode) {
        System.out.println("=========UserServiceImpl.queryUser=====");
        Map map = new HashMap<>();
        map.put("areaCode",areaCode);
        List<ConsultConfigArea> areas = commonMapper.queryAreaByAreaCode(map);
        return JSONObject.toJSONString(areas);
    }

    @TargetSource("ds1")
    @Transactional
    @Override
    public String addArea(ConsultConfigArea area) {
        commonMapper.addArea(area);
        return "OK";
    }
}
