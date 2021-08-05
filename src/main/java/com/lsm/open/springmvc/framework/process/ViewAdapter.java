package com.lsm.open.springmvc.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAdapter implements View {

    private ViewHandler viewHandler;

    /**
     * 渲染实现
     *
     * @param request
     * @param response
     * @param result
     */
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, Object result) {
        if (result instanceof String) {
            //转发
            viewHandler = new ForwardViewHandler();
            viewHandler.forward(request, response, result);
        } else {
            viewHandler = new PrintViewHandler();
            viewHandler.print(response, result);
        }
    }
}
