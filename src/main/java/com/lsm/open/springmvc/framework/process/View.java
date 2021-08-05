package com.lsm.open.springmvc.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 决定使用何种渲染方式
 */
public interface View {

    /**
     * 渲染方法
     *
     * @param request
     * @param response
     * @param result
     */
    void render(HttpServletRequest request, HttpServletResponse response, Object result);

}
