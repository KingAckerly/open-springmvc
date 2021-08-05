package com.lsm.open.springmvc.framework;


import com.lsm.open.springmvc.framework.view.ViewAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class DispacherServlet extends BaseInit {

    /**
     * 适配器对象
     */
    private ViewAdapter viewAdapter = new ViewAdapter();

    /**
     * 拦截用户所有请求
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1.获取用户请求的uri
            String uri = req.getRequestURI();
            Object result = invoke(uri);
            //4.响应结果-适配器模式
            if (result != null) {
                viewAdapter.render(req, resp, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用
     *
     * @param uri
     * @return
     * @throws Exception
     */
    public Object invoke(String uri) throws Exception {
        //2.根据uri获取method
        Method method = beanFactory.getMethod(uri);
        //3.执行反射调用
        if (method != null) {
            //return method.invoke(method.getDeclaringClass().newInstance(),null);
            return method.invoke(beanFactory.getUrlBean(uri), null);
        }
        return null;
    }
}
