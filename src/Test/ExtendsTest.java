package Test;

/**
 * @author ZAXIE
 * @date 2023/8/30 16:31
 */
public class ExtendsTest extends ParentClass {
    public static void main(String[] args) {
        TestChildClass childClass = new TestChildClass();
        System.out.println("children name : ");
        childClass.showName();
        TestChildClass.showStaticName(); 

        TestParentClass parentClass = new TestParentClass();
        System.out.println("parent name : ");
        parentClass.showName();
        TestParentClass.showStaticName();

        TestParentClass pc = new TestChildClass();
        System.out.println("upcasting name : ");
        parentClass.showName();

        System.out.println("\n\n\n\n\n\n");
        ParentClass test = new ExtendsTest();
        test.run();
    }

    @Override
    public void interfaceRun() {
        System.out.println("I'm interfaceRunImpl from " + this.getClass());
    }
}

abstract class ParentClass {
    public void run() {
        System.out.println("I'm run " + this.getClass());
        interfaceRun();
    }

    public abstract void interfaceRun();
}
