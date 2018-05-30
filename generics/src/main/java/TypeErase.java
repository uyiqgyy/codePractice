import java.lang.reflect.Field;

/**
 * Created by uyiqgyy on 2018/5/31.
 */
public class TypeErase {
    public static class Erasure <T>{
        T object;

        public Erasure(T object) {
            this.object = object;
        }

    }
    public static void main(String[] args) {
        Erasure<String> erasure = new Erasure<String>("hello");
        Class clazz = erasure.getClass();
        System.out.println("erasure class is:"+clazz.getName());
        //erasure class is:TypeErase$Erasure
        Field[] fs = clazz.getDeclaredFields();
        for ( Field f:fs) {
            System.out.println("Field name "+f.getName()+" type:"+f.getType().getName());
            //Field name object type:java.lang.Object
        }
    }
}
