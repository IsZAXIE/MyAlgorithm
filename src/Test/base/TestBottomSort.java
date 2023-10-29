package Test.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZAXIE
 * @date 2023/10/18 14:22
 */
public class TestBottomSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "AA"));
        list.add(new Student(2, "BB"));
        list.add(new Student(1, "CC"));
        list.add(new Student(1, "DD"));
        list.add(new Student(2, "EE"));
        list.add(new Student(1, "FF"));
        list.add(new Student(2, "GG"));
        list.add(new Student(1, "HH"));
        list.add(new Student(2, "II"));
        list.add(new Student(2, "JJ"));
        list.add(new Student(1, "KK"));

        List<Student> top = list.stream().filter(s -> s.getId() != 1).collect(Collectors.toList());
        List<Student> bottom = list.stream().filter(s -> s.getId() == 1).collect(Collectors.toList());
        top.addAll(bottom);
        list = top;
        System.out.println(list);
    }
}
