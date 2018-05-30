import java.util.HashSet;
import java.util.Set;

public class GenericMethod<E> {
    public <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }
    public void print(E e) {
        System.out.print(e);
    }
}
/*
generic method 's type parameter do not be influenced by generic class's type parameter.
* */