package com.lsm.open.springmvc.framework.util;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    /**
     * 定义一个注解的属性，属性名字叫value  default  默认值
     *
     * @return
     */
    String value() default "";
}
