package AOPTest.CircleTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZAXIE
 * @date 2023/9/9 17:09
 */
public class CircleAOPHandler implements InvocationHandler {

    Object object;

    public CircleAOPHandler(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object, args);
        return object;
    }
}
