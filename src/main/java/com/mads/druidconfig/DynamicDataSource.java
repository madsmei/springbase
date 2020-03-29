package com.mads.druidconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    /*
    * 返回一个字符串，这个字符串就是跟数据源对象绑定的字符串
    * */
    @Override
    protected Object determineCurrentLookupKey() {

        String ds = DynamicDataSourceHolder.getDs();

        System.out.println("===========选择的数据源：" + ds);

        return ds;
    }
}
