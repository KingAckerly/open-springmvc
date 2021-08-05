package com.lsm.open.springmvc.framework.parse;

import java.io.InputStream;

public abstract class ParseFile {

    /**
     * 加载指定文件
     *
     * @param is
     * @throws Exception
     */
    public abstract void load(InputStream is) throws Exception;

    /**
     * 加载指定文件
     *
     * @param path
     * @throws Exception
     */
    public abstract void load(String path) throws Exception;
}
