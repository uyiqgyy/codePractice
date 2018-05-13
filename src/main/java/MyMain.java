

import java.util.concurrent.TimeUnit;
public class MyMain {
    public static void main(String[] args) {
        // Creates a FileClock runnable object and a Threa

       FileLock task = new FileLock();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}  