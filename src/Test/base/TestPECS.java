package Test.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/9/4 08:57
 */
public class TestPECS {
    static class Parent1 {

        @Override
        public String toString() {
            return getClass().toString();
        }
    }

    static class Parent2 extends Parent1 {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class Parent3 extends Parent2 {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class T extends Parent3 {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class Child1 extends T {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class Child2 extends Child1 {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static class Child3 extends Child2 {
        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {

        // only put T and T's children
        List<? super T> superT = new ArrayList<>();
        /**
         * error cause by ParentX not children of T
         *
         * superT.add(new Parent1());
         * superT.add(new Parent2());
         * superT.add(new Parent3());
         */
        superT.add(new T());
        superT.add(new Child1());
        superT.add(new Child2());
        superT.add(new Child3());
        System.out.println(superT.get(0));
        System.out.println(superT.get(1));
        System.out.println(superT.get(2));
        System.out.println(superT.get(3));
        System.out.println(superT.get(4));
        System.out.println(superT.get(5));
        System.out.println(superT.get(6));


        // get T and T's children
        List<? extends T> extendsT = new ArrayList<>();
        /**
         * Error due to inability to know concrete classes of subclasses of T
         *
         * extendsT.add(new Parent1());
         * extendsT.add(new Parent2());
         * extendsT.add(new Parent3());
         * extendsT.add(new T());
         * extendsT.add(new Child1());
         * extendsT.add(new Child2());
         * extendsT.add(new Child3());
         */

        System.out.println(extendsT.get(0));
        System.out.println(extendsT.get(1));
        System.out.println(extendsT.get(2));
        System.out.println(extendsT.get(3));
        System.out.println(extendsT.get(4));
        System.out.println(extendsT.get(5));
        System.out.println(extendsT.get(6));
    }
}
