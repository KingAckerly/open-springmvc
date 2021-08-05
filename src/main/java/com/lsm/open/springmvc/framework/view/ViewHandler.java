package com.lsm.open.springmvc.framework.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewHandler {

    /**
     * 转发
     *
     * @param request
     * @param response
     * @param result
     */
    default void forward(HttpServletRequest request, HttpServletResponse response, Object result) {
    }

    /**
     * 输出JSON数据
     *
     * @param response
     * @param result
     */
    default void print(HttpServletResponse response, Object result) {
    }
}
