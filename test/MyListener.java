package com.ning.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
*   监听器的使用：
*       作用：监听作用域对象request,session,application的创建，销毁和内容的改变
*       使用：创建了一个实现了接口的java类
*       监听request--->ServletRequestListener 监听request对象的销毁和创建
*           requestDestroyed //销毁
*           requestInitialized  //创建
*           注意：形参可以获取监听的request对象
*       监听request--->ServletRequestAttributeListener 监听request作用域数据的变更
*           attributeAdded
*           attributeRemoved
*           attributeReplaced
*           注意：形参可以获取被监听的数据
*
*       监听session--->HttpSessionListener 监听session的创建和销毁
*           sessionCreated  创建
*           sessionDestroyed  销毁
*           注意：形参监听session对象
*       监听session--->HttpSessionAttributeListener  监听session数据的变更
*           注意：形参可以获取被监听的数据
*
*       监听application--->ServletContextListener  监听application对象的创建和销毁
*           contextInitialized 创建 服务器启动
*           contextDestroyed  销毁 服务器关闭
*
*       监听application--->ServletContextAttributeListener 监听application数据的变更
*           attributeAdded
*           attributeRemoved
*           attributeReplaced
*           注意：形参可以获取当前监听的数据
*       在web.xml中配置监听器
*
*
* */
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener,HttpSessionListener ,HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener {
    //request对象销毁
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("我被销毁了");
    }
    //request对象创建
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("我被创建了");
    }
    //监听request作用域数据的添加
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request中添加了一条数据-"+srae.getName()+":"+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }
    /*----------------------------------------------------------------------------------*/
    //监听session的创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session被创建了");
    }
    //监听session的销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session被销毁了");
    }
    //监听session数据的变更
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session中增加了一条数据"+se.getName()+":"+se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
    /*--------------------------------------------------------------*/
    //监听application的创建
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application对象被初始化了");
    }
    //监听application的销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application对象被销毁了");
    }
    //监听application的数据变更
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("application中存储了数据"+scae.getName()+":"+scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }
}
