package com.aspect;

import com.util.PersonProxyFactory;
import com.util.Testable;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
public class testPersonImpl {
    public static void main(String[] agrs) {
// jdk dynamic proxy
        System.out.println("******** jdk dynamic proxy ******** ");
        Testable jdkProxy = PersonProxyFactory.newJdkProxy();
        jdkProxy.sayHi();
        jdkProxy.sayBye();
    }
}
