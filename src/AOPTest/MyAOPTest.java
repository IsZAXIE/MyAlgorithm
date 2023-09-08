package AOPTest;

import Entity.ParentsInterface;

import java.lang.reflect.Proxy;

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
 */
public class MyAOPTest {

    public static final void testRunTime(ParentsInterface parentsInterface) {
        AOPHandler handler = new AOPHandler(parentsInterface);
        ParentsInterface pi = (ParentsInterface) Proxy.newProxyInstance(parentsInterface.getClass().getClassLoader(), new Class[]{ParentsInterface.class}, handler);
        pi.run();
    }
}
