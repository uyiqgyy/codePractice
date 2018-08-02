import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by uyiqgyy on 2018/8/2.
 */
public class LockTest {
    static String s = "";
    static Lock lock = new ReentrantLock();

    public static void test() {

        lock.lock();
        lock.tryLock();
        {
            s = null;
            System.out.println("work!");
        }
    }

    public static void main(String[] args) {
        test();
        test();
    }
}
