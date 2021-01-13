package com.mads.beans.import1;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现该接口的类只能通过其他类@Import的方式来加载，通常是启动类或配置类
 * 实现该接口的类拥有注册bean的能力。
 * 它通常和@Configuration配合使用，在@Configuration之前已注册的Bean，可以由ImportBeanDefinitionRegistrar接口来处理
 *   如果我们想实现类似 @CommentScan这样的功能。就需要实现此接口。
 *
 * @author Mads  2020/12/31 15:32
 */
public class ImportBeanDefinitionRegistrarDemo implements ImportBeanDefinitionRegistrar {
    /**
     * 这个方法是在收集完成以后调用的
     *
     * 这个方法可以拿到@Import的这个class的Annotation Metadata，以及此时的BeanDefinitionRegistry对象，通过BeanDefinitionRegistry
     * 就可以拿到目前所有注册的BeanDefinition，然后可以对这些BeanDefinition进行额外的修改或增强。
    **/
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

    }
}
