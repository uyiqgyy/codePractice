package com.util;


import com.aspect.MonitorSession;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
public class CGLibProxy implements MethodInterceptor {
    private static CGLibProxy instance = new CGLibProxy();
    private CGLibProxy() {
    }
    public static CGLibProxy getInstance() {
        return instance;
    }
    private Enhancer enhancer = new Enhancer();
    @SuppressWarnings("unchecked")
    public  <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        MonitorSession.begin(arg1.getName());
        Object obj = arg3.invokeSuper(arg0, arg2);
        MonitorSession.end();
        return obj;
    }
}
