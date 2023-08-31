package Test;

/**
 * @author ZAXIE
 * @date 2023/8/30 16:31
 */
public class MainTest {
    public static void main(String[] args) {
        TestChildClass childClass=new TestChildClass();
        System.out.println("children name : ");
        childClass.showName();
        TestChildClass.showStaticName();

        TestParentClass parentClass=new TestParentClass();
        System.out.println("parent name : ");
        parentClass.showName();
        TestParentClass.showStaticName();

        TestParentClass pc=new TestChildClass();
        System.out.println("upcasting name : ");
        parentClass.showName();
    }
}
