package com.mads.druidconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/*****
 * 实现 多数据源 要继承 AbstractRoutingDataSource 并实现下面的方法
 * 他里面 维护了一个 目标数据源的Map, 和一个默认数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /*
    * 返回一个字符串，这个字符串就是跟数据源对象绑定的字符串
    * 这个方法的操作由Spring完成调用，、
    * */
    @Override
    protected Object determineCurrentLookupKey() {

        String ds = DynamicDataSourceHolder.getDs();

        System.out.println("===========选择的数据源：" + ds);

        return ds;
    }
}
