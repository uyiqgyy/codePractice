import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by uyiqgyy on 2018/5/31.
 */
public class whyGenerics {
    private final static List numbers = new ArrayList();
    public static void main(String[] args) {
        numbers.add("String");
        numbers.add(1);

        for (Iterator i = numbers.iterator(); i.hasNext();) {
            Integer integer = (Integer) i.next();
            System.out.println(integer);
        }
    }

}
/*  compile time.
    Exception in thread "mxain" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
	at whyGenerics.main(whyGenerics.java:15)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
	*/
/* still need use raw type.
a. class literals.   eg. Set.class
b. instanceof.  eg. o instanceof Set
 */
