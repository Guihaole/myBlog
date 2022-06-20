package com.edu.beanFactory;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class BeanSelectImport implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
       //组件全限定名
        String[] arrStr={"com.edu.bean.A","com.edu.bean.B"};
        return arrStr;
    }
}
