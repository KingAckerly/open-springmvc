package com.lsm.open.springmvc.framework.factory;


import com.lsm.open.springmvc.controller.AccountController;
import com.lsm.open.springmvc.framework.util.ParseAnnotation;
import com.lsm.open.springmvc.framework.util.XmlBean;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;

public class XmlBeanFactory implements BeanFactory {

    /**
     * spring.xml中对应的实例 key=id
     * spring.xml中对应的实例 value=class对应的实例
     */
    private static Map<String, Object> beans;

    /**
     * 所有uri和Method的映射
     */
    private static Map<String, Method> methods;

    /**
     * 所有uri和bean的id映射对象
     */
    private static Map<String, String> urlIdMaps;

    /**
     * 1.初始化所有对应的实例(spring.xml)
     * 2.把实例化的对象存入到Map<String,Object>
     */
    public XmlBeanFactory() {
        initBeans();
    }

    /**
     * 传入要解析的文件
     *
     * @param path
     */
    public XmlBeanFactory(String path) {
        try {
            //解析文件
            XmlBean.load(path);
            initBeans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID获取实例
     *
     * @param id
     * @return
     */
    @Override
    public Object getBean(String id) {
        return beans.get(id);
    }

    /**
     * 根据uri获取实例
     *
     * @param uri
     * @return
     */
    @Override
    public Object getUrlBean(String uri) {
        //根据urlIdMaps获取对应的id
        String id = urlIdMaps.get(uri);
        if (!StringUtils.isEmpty(id)) {
            return beans.get(id);
        }
        return null;
    }

    /**
     * 根据uri获取method
     *
     * @param uri
     * @return
     */
    @Override
    public Method getMethod(String uri) {
        return methods.get(uri);
    }

    /**
     * 初始化操作
     */
    public void initBeans() {
        try {
            //初始化
            beans = XmlBean.initBeans();
            //构建methods中uri和beans中id的映射关系
            //methods
            //1.解析所有的类上@RequestMapping注解
            //2.将注解中的值(uri)和方法存储起来，存入到Map<String,Method>
            methods = ParseAnnotation.parseRequestMapping();
            //beans
            urlIdMaps = ParseAnnotation.parseUrlMappingInstance(methods, beans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory("spring.xml");
        AccountController accountController1 = (AccountController) beanFactory.getBean("accountController");
        AccountController accountController2 = (AccountController) beanFactory.getBean("accountController");
        System.out.println(accountController1);
        System.out.println(accountController1 == accountController2);
    }
}
