package AOPTest.CircleTest;

import Entity.AOPInterface.CircleTestInterface;
import Entity.MyException.TestException;
import Util.ColorPrintUtils;

import java.lang.reflect.Proxy;

/**
 * @author ZAXIE
 * @date 2023/9/9 17:12
 *
 * this function can't use yet!
 */
public class CircleAopTest {
    public static final void circleTest(CircleTestInterface circleTestInterface){
        CircleAOPHandler handler=new CircleAOPHandler(circleTestInterface);
        CircleTestInterface cti= (CircleTestInterface) Proxy.newProxyInstance(circleTestInterface.getClass().getClassLoader(), new Class[]{CircleTestInterface.class},handler);
        try {
            cti.test();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("o.O");
//            System.err.println(e.getMsg());
        }
    }
}