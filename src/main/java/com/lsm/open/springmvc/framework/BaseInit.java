package com.lsm.open.springmvc.framework;


import com.lsm.open.springmvc.framework.factory.BeanFactory;
import com.lsm.open.springmvc.framework.factory.XmlBeanFactory;
import com.lsm.open.springmvc.framework.parse.ParseFile;
import com.lsm.open.springmvc.framework.parse.ParseXml;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseInit extends HttpServlet {

    //1.解析所有的类上@RequestMapping注解
    //2.将注解中的值(uri)和方法存储起来，存入到Map<String,Method>
    //public static Map<String, Method> methods;

    /**
     * 解析对象
     */
    private ParseFile parseFile = new ParseXml();

    /**
     * 实例化工厂对象
     */
    public BeanFactory beanFactory;

    /**
     * 重写init方法,用于做初始化操作
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //1.解析所有的类上@RequestMapping注解
            //2.将注解中的值(uri)和方法存储起来，存入到Map<String,Method>
            //methods = ParseAnnotation.parseRequestMapping();
            //获取需要解析的xml/properties/yaml文件,如果需要解析，则通知其他对象进行解析
            String cfg = config.getInitParameter("contextLocation");
            if (!StringUtils.isEmpty(cfg)) {
                //加载解析xml文件
                parseFile.load(cfg);
                //实例化工厂
                beanFactory = new XmlBeanFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
