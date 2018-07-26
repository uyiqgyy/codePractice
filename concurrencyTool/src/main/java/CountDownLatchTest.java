import java.util.concurrent.CountDownLatch;

/**
 * Created by uyiqgyy on 2018/7/27.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();// 减少数量
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();//等待指定数量用完
        System.out.println("3");
    }}
