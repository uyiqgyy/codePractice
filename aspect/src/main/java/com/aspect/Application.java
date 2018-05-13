package com.aspect;

import com.util.PersonProxyFactory;
import com.util.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
@SpringBootApplication
public class Application {
    @Autowired
    private Testable person;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // spring aop
            System.out.println("******** spring aop ******** ");
            person.sayHi();
            person.sayBye();

            System.out.println("******** jdk dynamic proxy ******** ");
            Testable jdkProxy = PersonProxyFactory.newJdkProxy();
            jdkProxy.sayHi();
            jdkProxy.sayBye();
            System.out.println("******** cglib proxy ******** ");
            PersonImpl cglibProxy = PersonProxyFactory.newCglibProxy();
            cglibProxy.sayHi();
            cglibProxy.sayBye();
        };
    }
}
