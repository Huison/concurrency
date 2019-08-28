package com.example.concurrency.annocations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记[线程不安全]的类
 * @Target      表示注解作用的目标
 * @Retention   表示注解存在的周期
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {


    String value() default "";

}
