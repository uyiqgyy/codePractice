import java.util.ArrayList;
import java.util.List;

/**
 * Created by uyiqgyy on 2018/6/2.
 */
public class gcDemo {
    public static void main(String[] args) {
        List<byte[]> data = new ArrayList<>();
        int i = 1;

        while (true) {
            byte[] buf = new byte[1024*1024];
            data.add(buf);
            if(i++ % 10 == 0) data = new ArrayList<>();
        }
    }
}
