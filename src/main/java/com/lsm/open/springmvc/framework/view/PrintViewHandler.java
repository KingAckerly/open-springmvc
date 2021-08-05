package com.lsm.open.springmvc.framework.view;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class PrintViewHandler implements ViewHandler {

    /**
     * JSON数据输出
     *
     * @param response
     * @param result
     */
    @Override
    public void print(HttpServletResponse response, Object result) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(result));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
