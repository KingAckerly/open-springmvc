package com.lsm.open.springmvc.framework.parse;

import java.io.InputStream;

public class ParseYaml extends ParseFile {
    @Override
    public void load(InputStream is) throws Exception {
        System.out.println("加载yaml文件");
    }

    @Override
    public void load(String path) throws Exception {
        System.out.println("加载yaml文件");
    }
}
