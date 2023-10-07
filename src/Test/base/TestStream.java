package Test.base;

import Util.ColorPrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author ZAXIE
 * @date 2023/9/11 15:40
 */
public class TestStream {

    public static void main(String[] args) {
        List<Float> list = new ArrayList<>(asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10000.0f));
        /*
        Stream<Float> stream = list.stream().peek(a -> {
            a *= a;
        });
        */

        /*
        List<MyInteger> list = new ArrayList<>(asList(new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger(),new MyInteger()));
        Stream<MyInteger> stream = list.stream().peek(a -> {
            a.i *= a.i;
        });
        */


        ColorPrintUtils.printPurple("After Stream\n");
        printList("before return ", list);

        System.out.print("\tStream");
        list.stream().peek(a -> {
            a *= a;
        }).forEach(a -> System.out.print("\t" + a));
        System.out.println();


        list = list.stream().peek(a -> {
            a *= a;
        }).toList();
        printList("after return ", list);

        System.out.println();
    }

    private static <T> void printList(String note, List<T> list) {
        System.out.print("\tlist : " + list);
        System.out.println();
    }

    static class MyInteger {
        public MyInteger() {
            this.i = (int) (Math.random() * 100);
        }

        int i;

        @Override
        public String toString() {
            return "    " + i;
        }
    }
}
