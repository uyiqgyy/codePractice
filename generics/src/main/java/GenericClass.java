import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uyiqgyy on 2018/5/31.
 */
public class GenericClass {
    public class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {
            //1.
            //elements = new E[DEFAULT_INITIAL_CAPACITY];
            //type parameter 'E' cannot be instantiated directly
            //2.
            //elements = new Object[DEFAULT_INITIAL_CAPACITY];
            //Required E[], found Object[]
            elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }
        public E pop() {
            if (size == 0 ) {
                throw new RuntimeException();
            }
            E result = elements[--size];
            elements[size] = null;
            return  result;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());
    }
}


/**
 * A. prefer list to arrays
 *  1. Arrays is covariant - 协变
 *     if Sub is a subtype of Super, then Sub[] is a subtype of Super[]
 *
 *     Generic is invariant .
 *     List<Sub> is not a subtype of List<Super>
 *  2. Arrays is reified . know and enforce their element types at **runtime**
 *     Generic only constrain at compile time and will be erased type info at runtime
 *     .reason for freely with legacy code.
 *     java.lang.ArrayStoreException
 *  3. varargs. ...
 * B. <E extends Stack> , every type is subtype of itself.
 * c. ? unbound wildcard . no permit to write
 * d. E unbound type parameter
 * e. ? extends T , ? super T, bound wildcard
 * f. E extends T , E extends T, bound type parameter
 * g. PECS
 * h. E extends Class & interface1 & interface2
 *
 1. T 代表一般的任何类。
 2. E 代表 Element 的意思，或者 Exception 异常的意思。
 3. K 代表 Key 的意思。
 4. V 代表 Value 的意思，通常与 K 一起配合使用。
 5. S 代表 Subtype 的意思。
 *
 * */