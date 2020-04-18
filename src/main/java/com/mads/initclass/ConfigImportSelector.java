package com.mads.initclass;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Description: ImportSelector接口是至spring中导入外部配置的核心接口
 *
 *其主要作用是收集需要导入的配置类，如果该接口的实现类同时实现EnvironmentAware， BeanFactoryAware ，
 * BeanClassLoaderAware或者ResourceLoaderAware，那么在调用其selectImports方法之前先调用上述接口中对应的方法
 *
 * 1.ImportSelector的导入实现是通过BeanFactoryPostProcessor接口的子接口BeanDefinitionRegistryPostProcessor来实现的。
 * 2.ImportSelector接口的处理是伴随着@Configuration注解的处理一起处理的。
 * 3.ImportSelector接口可以实现自定义条件选择性导入classes。
 * 4.ImportSelector接口的字接口DeferredImportSelector在所有@Configuration处理完成后才被处理的。
 * 5.处理ImportSelector接口时，bean定义已经被加载，但是bean还没有被实例化。
 * 6.Spring Bootn的自动配置功能就是通过DeferredImportSelector接口的实现类EnableAutoConfigurationImportSelector做到的。
 * @Date 2020/4/16
 * @Version V1.0
 * @Author Mads
 **/
public class ConfigImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //拿到 对应的 类的属性值。这里Object.class.getName()只是为了方便代码不报错
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(Object.class.getName(), true);

        return new String[0];
    }
}
