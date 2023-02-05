package org.books.tanzicai;

import org.books.tanzicai.BeansConfig.BeansConfig;
import org.books.tanzicai.entity.User;
import org.books.tanzicai.service.AopDemoServiceImpl;
import org.books.tanzicai.service.IJdkProxyService;
import org.books.tanzicai.service.IJdkProxyServiceImpl;
import org.books.tanzicai.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author tanzicai
 */
public class App {
    /**
     * main interfaces.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // create and configure beans（use xml）
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspects.xml", "daos.xml", "services.xml");

        // use class configuration（use class）
        // AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);

        // create and configure beans（use 注解）
        // AnnotationConfigApplicationContext annotationConfigApplicationContext1 = new AnnotationConfigApplicationContext("org.books.tanzicai");
        //retrieve configured instance(xml)
        //UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);

        //UserServiceImpl userService = annotationConfigApplicationContext.getBean("userService", UserServiceImpl.class);

        // UserServiceImpl userService = annotationConfigApplicationContext1.getBean(UserServiceImpl.class);
        //use configured instance
        // List<User> userList = userService.findUserList();

        // print info from beans
        // userList.forEach(a-> System.out.println(a.getName()+","+a.getAge()));

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("org.books.tanzicai");
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("aspects.xml");
        IJdkProxyServiceImpl iJdkProxyServiceImpl = annotationConfigApplicationContext.getBean(IJdkProxyServiceImpl.class);
        iJdkProxyServiceImpl.doMethod1();
        iJdkProxyServiceImpl.doMethod2();
        try {
            String s = iJdkProxyServiceImpl.doMethod3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}