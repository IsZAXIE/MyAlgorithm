package Test.base;

/**
 * @author ZAXIE
 * @date 2023/10/4 16:50
 */
public class TestInnerClass {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Test());
        }
    }
    public static class Test{
        int i = 0;
        static int j = 0;

        @Override
        public String toString() {
            return "Test{" +
                    "i+1 = " + ++i +
                    " j+1 = " + ++j +
                    '}';
        }
    }
}
