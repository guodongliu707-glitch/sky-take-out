package com.sky.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// 手动设计的注解类，用于标识某个方法需要进行公共字段的自动填充处理
///
@Target(ElementType.METHOD)
///通过Target注解，以及ElementType.METHOD规范该注解只能用于方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

}
