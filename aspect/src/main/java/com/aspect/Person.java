package com.aspect;

import com.util.Testable;
import org.springframework.stereotype.Service;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
@Service
public class Person implements Testable {
    @Override
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}
