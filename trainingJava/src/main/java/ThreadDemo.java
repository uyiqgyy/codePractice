import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by uyiqgyy on 2018/6/2.
 */
public class ThreadDemo {
    static Lock o1 = new ReentrantLock();
    static Lock o2 = new ReentrantLock();
    public static void main(String[] args) throws Exception {
       //内部类对变量对访问
        Thread t1 = new Thread(){
            public void run() {
                setName("Yu");
                while (true) {
                   if(o1.tryLock()) {
                        if(o2.tryLock()) {
                            System.out.println(getName() + "is running !");
                            Thread.interrupted();
                            o2.unlock();
                        }
                        o1.unlock();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                setName("Min");
                while (true) {
                    if(o2.tryLock()) {
                        if(o1.tryLock()) {
                            System.out.println(getName() + "is running !");
                            o1.unlock();
                        }
                        o2.unlock();
                    }
                }
            }
        };


                t1.start();
                t2.start();


            }
        }
