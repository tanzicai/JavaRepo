package org.books.tanzicai.service;

import org.springframework.stereotype.Service;

/**
 * @author tanzicai
 */

public class AopDemoServiceImpl {
    /**
     * 测试无返回值
     */
    public  void domethod1(){
        System.out.println("AopDemoServiceImpl.doMethod1()");
    }

    /**
     * 无参数
     * @return "hello world" String
     */
    public  String domethod2(){
        System.out.println("AopDemoServiceImpl.doMethod2()");
        return "hello world";
    }

    /**
     * 无参数
     * @return new Exception
     * @throws Exception
     */
    public String doMethod3() throws Exception {
        System.out.println("AopDemoServiceImpl.doMethod3()");
        throw new Exception("some exception");
    }

}
