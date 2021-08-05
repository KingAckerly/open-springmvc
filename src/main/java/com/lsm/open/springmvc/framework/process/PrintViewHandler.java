package com.lsm.open.springmvc.framework.process;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintViewHandler implements ViewHandler {

    /**
     * 输出json
     *
     * @param response
     * @param result
     */
    @Override
    public void print(HttpServletResponse response, Object result) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
