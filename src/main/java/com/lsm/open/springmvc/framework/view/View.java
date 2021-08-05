package com.lsm.open.springmvc.framework.view;

public interface View {
    /**
     * 判断响应方式
     * 1:转发
     * 2:输出JSON数据
     *
     * @param result
     * @return
     */
    Integer method(Object result);
}
