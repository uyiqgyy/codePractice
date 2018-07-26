import java.io.File;

/**
 * Created by uyiqgyy on 2018/6/1.
 */
public class stackDemo {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        String path = "/bin";
        String key = "sh";
        File file = new File(path);
       search(file,key);
        //new DirectoryScan(file, key).run();
        //new RecurseDirectoryThread().search(file,key);
        while (Thread.activeCount() >1) {
            Thread.yield();
            //System.out.println(Thread.activeCount());//Thread.getAllStackTraces();
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));
    }


    public static void search(File file, String key){
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File f : files) {
                    new Thread(){
                        @Override
                        public void run() {
                            search(f, key);
                        }
                    }.start();
                }
            }
        } else if(file.getName().contains(key)) {
            System.out.println(String.format(" %s find File %s",file.getAbsolutePath(), file.getName()));
        }
    }
}
