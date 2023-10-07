package Test.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/10/7 08:37
 */
public class TestListSwap<T> {

    List<T> list = new ArrayList<>();

    public static void main(String[] args) {
        TestListSwap<Student> students = new TestListSwap<>();
        students.list.add(new Student("test1"));
        students.list.add(new Student("test2"));
        students.list.add(new Student("test3"));
        students.list.add(new Student("test4"));
        students.listSwap(1, 3);
        System.out.println(students);
    }

    /**
     * list store the address of object, so it can be swapped by a middle parameter.
     */
    private void listSwap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    @Override
    public String toString() {
        return "TestListSwap{" +
                "list=" + list +
                '}';
    }
}
