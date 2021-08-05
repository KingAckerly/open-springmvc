package com.lsm.open.springmvc.framework.factory;

import java.lang.reflect.Method;

public interface BeanFactory {
    /**
     * 根据id获取对应实例
     *
     * @param id
     * @return
     */
    Object getBean(String id);

    /**
     * 根据uri获取指定实例
     *
     * @param uri
     * @return
     */
    Object getUrlBean(String uri);

    Method getMethod(String uri);
}
