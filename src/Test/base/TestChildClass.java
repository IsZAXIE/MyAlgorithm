package Test.base;

/**
 * @author ZAXIE
 * @date 2023/8/30 16:28
 */
public class TestChildClass extends TestParentClass{
    public String name="childrenName";
    public static String staticName="childrenStaticName";

    public void showName(){
        System.out.println("\t"+name);
    }

    public static void showStaticName(){
        System.out.println("\t"+staticName);
    }
}
