package com.aspect;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
public class MethodMonitor {
    private long start;
    private String method;
    public MethodMonitor(String method) {
        this.method = method;
        System.out.println("begin monitor.. " + method);
        this.start = System.currentTimeMillis();
    }
    public void log() {
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("end monitor.. "+ method);
        System.out.println("Method: " + method + ", execution time: " + elapsedTime + " milliseconds.");
    }
}
