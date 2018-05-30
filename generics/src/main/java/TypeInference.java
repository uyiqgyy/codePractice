/**
 * Created by uyiqgyy on 2018/5/31.
 */
public class TypeInference {
/*
* 编译器判断泛型方法的实际类型参数的过程叫做类型推断,类型推断的实现方法是一种非常复杂的过程.
根据调用泛型方法时实际传递的参数类型或返回值类型来推断,具体规则如下:
如果某类型变量只在方法参数列表或返回值的一处被调用了,那根据调用该方法时该处的实际类型来确定,即直接根据调用方法时传递的实际类型或方法返回值的类型来确定泛型方法的参数类型.例如: swap(new String[3],3,4) --->static <E>  void swap(E[] a,int i,int t)
当某个类型变量在方法的参数列表和返回值中被多次利用了,而且在调用方法时这多处的实际类型又是一样的,那么这也可以很明显的知道此泛型方法的参数类型.例如: add(3,5) --> static <T> T add(T a,T b)
当某个类型变量在方法的参数列表和返回值中被多次利用了,而且在调用方法时这多处的实际类型又对应不同的类型,且返回值是void,那么这时取多处实际变量类型的最大交集.例如: fill(new Integer[3],3.5f) --> static <T> void fill(T[] a,T i) ,此时T为Number,编译不会报错,但运行有问题.
当某个类型变量在方法的参数列表和返回值中被多次利用了,且返回值不为空,在调用方法时这多处的实际类型又对应不同的类型,那么优先考虑返回值的类型.int x = add(3,3.5f) --> static <T> T add(T a,T b)
参数类型的类型推断具有传递性,
copy(new Integer[5],new String[5]) --> static <T> void copy(T[] a, T[] b)  T为Object类型,没有问题
copy(new Vector<String>(),new Integer[5]) --> static <T> void copy(Collection<T> a, T[] b)    在new Vector<String>()时决定了T为String类型,而new Integer[5]不是String类型,这样会报错*/
}
