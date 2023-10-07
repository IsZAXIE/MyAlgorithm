package Test.entity;

import Entity.MyHeap;
import Test.entity.TestEntity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/10/7 09:07
 */
public class TestMyHeap {
    public static void main(String[] args) {
        MyHeap<Student> heap = new MyHeap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });

        List<Student> list = new ArrayList<>();
        list.add(new Student(8,"student8"));
        list.add(new Student(7,"student7"));
        list.add(new Student(6,"student6"));
        list.add(new Student(5,"student5"));
        list.add(new Student(4,"student4"));
        list.add(new Student(3,"student3"));
        list.add(new Student(2,"student2"));
        list.add(new Student(1,"student1"));
        list.add(new Student(0,"student0"));
        heap.initHeap(list, true);
        heap.check();
    }
}
