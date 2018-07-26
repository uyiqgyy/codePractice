import java.io.File;

/**
 * Created by uyiqgyy on 2018/6/2.
 */
public class RecurseDirectoryThread {
    public static class DirectoryScan implements Runnable {
        private File file;
        private String keyWords;

        public DirectoryScan(File file, String key) {
            this.file = file;
            this.keyWords = key;
        }

        @Override
        public void run() {
            printFileName();
        }

        public void printFileName() {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                if(files != null) {
                    for (File f : files) {
                        new Thread(new DirectoryScan(f,keyWords)).start();
                        //new Thread(new DirectoryScan(f,keyWords)).start();
                    }
                }
            } else if(file.getName().contains(keyWords)) {
                System.out.println(String.format(" %s find File %s",file.getAbsolutePath(), file.getName()));
            }
        }
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        String path ="/bin";
        String key = "sh";
        File file = new File(path);
        new Thread(new DirectoryScan(file,key)).start();
        //new DirectoryScan(file, key).run();
        //new RecurseDirectoryThread().search(file,key);
        while (Thread.activeCount() > 1){
            Thread.yield();
            //System.out.println(Thread.activeCount());//Thread.getAllStackTraces();
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));
    }

    public void search(File file, String key) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File f : files) {
                   new Thread(){
                       public void run(){
                           search(file, key)  ;
                       }
                   }.start();
                }
            }
        } else if(file.getName().contains(key)) {
            System.out.println(String.format(" %s find File %s",file.getAbsolutePath(), file.getName()));
        }
    }
}
