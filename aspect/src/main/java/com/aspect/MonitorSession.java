package com.aspect;

/**
 * Created by uyiqgyy on 2018/5/13.
 */
public class MonitorSession {
    private static ThreadLocal<MethodMonitor> monitorThreadLocal =
            new ThreadLocal<>();
    public static void begin(String method) {
        MethodMonitor logger = new MethodMonitor(method);
        monitorThreadLocal.set(logger);
    }
    public static void end() {
        MethodMonitor logger = monitorThreadLocal.get();
        logger.log();
    }
}
