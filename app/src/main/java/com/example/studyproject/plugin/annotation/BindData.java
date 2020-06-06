package com.example.studyproject.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description: 标定需要解析的key
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // 目标
public @interface BindData {

    // 定义枚举
    enum EnumType {
         FIELD,OBJECT
    }

    String value();
    EnumType type();
}
