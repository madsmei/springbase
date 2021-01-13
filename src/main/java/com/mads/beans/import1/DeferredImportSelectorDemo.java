package com.mads.beans.import1;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是springboot 自动配置用的接口。它的父级也是 ImportSelector，区在在于这个接口 会提供默认配置（sb的特性）
 * @author Mads  2021/1/13 10:03
 */
public class DeferredImportSelectorDemo implements DeferredImportSelector {

    /***
     * 这个是 DeferredImportSelector 的父类方法。如果没有下面的 {@link DeferredImportSelectorGroupDemo} 则会则用。否则 使用下面的
     *   @author Mads 2021/1/13
    **/
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }


    //先调用这个 1
    @Override
    public Class<? extends Group> getImportGroup() {
        return DeferredImportSelectorGroupDemo.class;
    }

    public static class DeferredImportSelectorGroupDemo implements DeferredImportSelector.Group {
        List<Entry> list = new ArrayList<>();

        /***
         *  再先调用这个 2
         *  bean的收集
         *   @author Mads 2021/1/13
        **/
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            String[] selectImports = selector.selectImports(metadata);
            for (String selectImport : selectImports) {
                list.add(new Entry(metadata, selectImport));
            }
        }

        /***
         * 最后调用这个 3
         *  返回 收集的bean
         *   @author Mads 2021/1/13
        **/
        @Override
        public Iterable<Entry> selectImports() {
            return list;
        }
    }
}
