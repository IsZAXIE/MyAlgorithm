package Entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ZAXIE
 * @date 2023/8/31 08:08
 */
public interface ParentsInterface {

    // implement this interface and Override this method, so you can use AOPTest to test you function.
    // if you want to show function names you should sout functions name
    default Object run() {
        return null;
    }

    // this method will invoke automatic by using MyAOPTest.testRunTime(Class<?> clazz)
    // function name will be autofilled in console.
    default Object run(Method method, Object o) throws InvocationTargetException, IllegalAccessException {
        method.invoke(o);
        return method.getName();
    }
}
