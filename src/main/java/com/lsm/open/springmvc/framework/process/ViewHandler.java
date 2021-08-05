package com.lsm.open.springmvc.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义不同渲染(响应)方式
 */
public interface ViewHandler {

    /**
     * json输出
     *
     * @param response
     * @param result
     */
    default void print(HttpServletResponse response, Object result) {
    }

    /**
     * 转发
     *
     * @param request
     * @param response
     * @param result
     */
    default void forward(HttpServletRequest request, HttpServletResponse response, Object result) {
    }
}
