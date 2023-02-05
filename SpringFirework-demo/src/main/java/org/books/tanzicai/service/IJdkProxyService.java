package org.books.tanzicai.service;


import org.springframework.stereotype.Service;

/**
 * jdk proxy service
 *
 * @author tanzicai
 */

public interface IJdkProxyService {
    void doMethod1();

    String doMethod2();

    String doMethod3() throws Exception;
}
