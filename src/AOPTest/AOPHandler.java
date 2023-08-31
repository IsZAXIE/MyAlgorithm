package AOPTest;

import Utils.ColorPrintUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZAXIE
 * @date 2023/8/31 08:13
 */
public class AOPHandler implements InvocationHandler {
    Object object;

    public AOPHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Before
        Long startTime = System.currentTimeMillis();

        Object o=method.invoke(object,args);

        // After
        Long endTime = System.currentTimeMillis();
        ColorPrintUtils.printCyan(method.getName()+" run time : "+(endTime-startTime)+" ms");
        System.out.println();


        return o;

    }
}
