package AOPTest;

import Entity.ParentsInterface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/8/31 08:06
 * if you want to use AOP to test you program, you just need to use this class.
 * <p>
 * use method :
 * 1. Implements ParentsInterface and Override run();
 * 2. write your method except <method>main()</method> in your class ;
 * 3. MyAOPTest.testRunTime( <code>new 「your Class Name」()</code>) in main();
 * eg:
 * @Override public Object run() {
 * sort();
 * return null;
 * }
 * public static void main(String[] args) {
 * MyAOPTest.testRunTime(new MergeSort());
 * }
 * private static void sort() {...}
 *
 *
 * if you want to auto test all of '<code>public</code>' methods don't have any parameter, you can just
 * 1. implement ParentInterface and
 * 2. write MyAOPTest.testRunTime(${className}.class);
 * like
 * 1. public class MergeSort implements ParentsInterface{...}
 * 2. public static void main(String[] args) {
 *         MyAOPTest.testRunTime(MergeSort.class);
 *    }
 */
public class MyAOPTest {
    static List<Method> methodList;

    static Object obj;

    public static final void testRunTime(Class<?> clazz) {
        methodList = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers()) && (!m.getName().equals("main")) && m.getParameterCount() == 0)
                // filter all public method then remove main and make sure all public method has no parameter
                .toList();
        // remove main in methodList

        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        testRunTime((ParentsInterface) obj);
    }

    public static final void testRunTime(ParentsInterface parentsInterface) {
        AOPHandler handler = new AOPHandler(parentsInterface);
        ParentsInterface pi = (ParentsInterface) Proxy.newProxyInstance(parentsInterface.getClass().getClassLoader(), new Class[]{ParentsInterface.class}, handler);
        // use reflex get all public methods in this class
        if (methodList != null && methodList.size() != 0) {
            for (Method m : methodList) {
                try {
                    System.out.println(m.getName());
                    pi.run(m, obj);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } else {
            pi.run();
        }
    }
}
