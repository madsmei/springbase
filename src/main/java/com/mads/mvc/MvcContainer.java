package com.mads.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/****
 *
 * Springmvc容器
 *
 * 扫描  controller层的
 */
@ComponentScan(value = "com.mads",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class MvcContainer {
}
