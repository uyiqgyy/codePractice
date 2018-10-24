import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by uyiqgyy on 2018/10/24.
 */
public class HelloWorld {
       public static void main(String[] args) {
           /**
            * IoC - Inversion of Control
            */

           /**
            * BeanFactory
            */
           BeanFactory beanFactory = new XmlBeanFactory();

           /**
            * ApplicationContext
            */

           ApplicationContext applicationContext = new FileSystemXmlApplicationContext();



       }
}
