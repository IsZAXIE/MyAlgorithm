package Test;

/**
 * @author ZAXIE
 * @date 2023/8/30 16:27
 */
public class TestParentClass {

    public String name="ParentName";
    public static String staticName="ParentStaticName";

    public void showName(){
        System.out.println("\t"+name);
    }

    public static void showStaticName(){
        System.out.println("\t"+staticName);
    }
}
