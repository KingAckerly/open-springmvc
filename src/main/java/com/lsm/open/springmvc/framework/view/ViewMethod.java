package com.lsm.open.springmvc.framework.view;

public class ViewMethod implements View {
    @Override
    public Integer method(Object result) {
        if (result instanceof String) {
            //转发
            return 1;
        }
        return 2;
    }
}
