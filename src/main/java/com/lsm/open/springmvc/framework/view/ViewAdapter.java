package com.lsm.open.springmvc.framework.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAdapter {

    /**
     * 渲染
     */
    private ViewHandler viewHandler;
    /**
     * 判断渲染方式
     */
    private View view = new ViewMethod();

    /**
     * 执行响应
     *
     * @param request
     * @param response
     * @param result
     */
    public void render(HttpServletRequest request, HttpServletResponse response, Object result) {
        //判断渲染方式
        Integer method = view.method(result);
        //根据不同渲染方式创建不同实例
        if (method == 1) {
            //forward
            viewHandler = new ForwardViewHandler();
            viewHandler.forward(request, response, result);
        } else {
            //json输出
            viewHandler = new PrintViewHandler();
            viewHandler.print(response, result);
        }
    }
}
