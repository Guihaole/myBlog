package com.offcn.end;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Spring {
    String str();

    String username() default "guihaole";

    int a();
    Class value();
//    EnumClass ENUM_CLASS();
//    Override abc();

}
