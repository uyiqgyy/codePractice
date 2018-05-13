package com.util;

import com.aspect.PersonImpl;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
public class PersonProxyFactory {
    public static Testable newJdkProxy() {
        // 代理PersonImpl
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Testable proxy = dynamicProxy.getProxy();
        return proxy;
    }
    public static PersonImpl newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        PersonImpl proxy = cglibProxy.getProxy(PersonImpl.class);
        return proxy;
    }
}
