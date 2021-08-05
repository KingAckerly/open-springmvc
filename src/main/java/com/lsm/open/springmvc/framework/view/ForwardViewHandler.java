package com.lsm.open.springmvc.framework.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardViewHandler implements ViewHandler {

    /**
     * 转发
     *
     * @param request
     * @param response
     * @param result
     */
    @Override
    public void forward(HttpServletRequest request, HttpServletResponse response, Object result) {
        try {
            request.getRequestDispatcher(result.toString()).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
