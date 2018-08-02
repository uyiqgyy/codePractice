/**
 * Created by uyiqgyy on 2018/8/2.
 */
public class SynchronizedTest {
    static String s = "";
    public static void test() {

        synchronized (s){
            s = null;
           System.out.println("work!");
        }
    }

    public static void main(String[] args) {
        test();
        test();
    }
}
