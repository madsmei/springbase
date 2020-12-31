package com.mads.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/*****
 * Spring容器
 * 扫描 排除 controller层 以外的包
 */
@ComponentScan(value = "com.mads", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class SpringContainer {
}
