import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation {
    @Test(a=2, b=5)
    public void test(int a, int b) {
        System.out.println("Method called with parameters: a=" + a + ", b=" + b);
    }

    public static void main(String[] args) {
        Annotation obj = new Annotation();
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                int a = annotation.a();
                int b = annotation.b();
                try {
                    method.invoke(obj, a, b);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}