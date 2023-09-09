package AOPTest;

import Util.ColorPrintUtils;

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
        ColorPrintUtils.printCyan("Method "+o+"() run time : "+(endTime-startTime)+" ms");
        System.out.println();
        if(endTime-startTime>1000){
            System.err.println("time out : "+(endTime-startTime));
            System.out.println();
        }
        System.out.println();


        return o;

    }
}
