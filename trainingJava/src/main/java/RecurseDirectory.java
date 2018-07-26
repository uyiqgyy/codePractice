import java.io.File;

/**
 * Created by uyiqgyy on 2018/6/2.
 */
public class RecurseDirectory {

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public File file;
    public String keyWords;
    public RecurseDirectory(File file, String key) {
        this.file = file;
        this.keyWords = key;
    }
    public void printFileName(File file, String key) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File f : files) {
                printFileName(f,key);
                }
            }
        } else if(file.getName().contains(key)) {
            System.out.println(String.format(" %s find File %s",file.getAbsolutePath(), file.getName()));
        }
    }
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        File file = new File("/bin");

        RecurseDirectory recurseDirectory = new RecurseDirectory(file,"sh");

        recurseDirectory.printFileName(file,recurseDirectory.getKeyWords());

        System.out.println("Time " + (System.currentTimeMillis() - start));

    }
}
