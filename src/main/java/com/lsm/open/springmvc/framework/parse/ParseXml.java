package com.lsm.open.springmvc.framework.parse;

import com.lsm.open.springmvc.framework.util.XmlBean;

import java.io.InputStream;

public class ParseXml extends ParseFile {

    @Override
    public void load(InputStream is) throws Exception {
        System.out.println("加载XML文件");
        XmlBean.load(is);
    }

    @Override
    public void load(String path) throws Exception {
        System.out.println("加载XML文件");
        XmlBean.load(path);
    }
}
