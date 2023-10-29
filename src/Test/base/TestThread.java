package Test.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * @author ZAXIE
 * @date 2023/9/18 09:06
 */
public class TestThread {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) {

        Boolean bo = true;
        List<Boolean> booleans = new ArrayList<>(List.of(true));

        // Boolean object
        Thread thread = new Thread(new Runnable() {
            Boolean temp;

            @Override
            public void run() {
                temp = !bo;
                System.out.println("temp : " + temp + "\tthread bo = " + bo);
                ;
            }
        });
        thread.start();

        /**
         * List<Boolean> this thread can change original element
         * cause list is an entity rather than base-type
         */
        Thread threadR = new Thread(() -> {
            List<Boolean> booleanList = booleans;
            if (booleanList.size() > 0) {
                booleanList.set(0, !booleanList.get(0));
                System.out.println("booleanList : " + booleanList + "\tori boolean list" + booleans);
            }
        });
        threadR.start();

        System.out.println();
        System.out.println("bo = " + bo);
        for (int i = 0; i < 10; i++) {
            Thread threadRunnable = new Thread(new RunnableImpl(bo));
            threadRunnable.start();
        }
        System.out.println();

        try {
            sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("bo = " + bo);


        Student student = new Student("My name is ");

        for (int i = 0; i < 10; i++) {
            Thread threadStu = new Thread(new RunnableObjImpl(student, i));
            threadStu.start();
        }
    }
}

class RunnableImpl implements Runnable {
    Boolean threadBo;

    public RunnableImpl() {
    }

    public RunnableImpl(Boolean b) {
        this.threadBo = b;
    }

    @Override
    public void run() {
        threadBo = !threadBo;
        System.out.println("new threadBo : " + threadBo);
    }
}

class RunnableObjImpl implements Runnable {

    private Student student;
    private Integer num = 0;

    public RunnableObjImpl() {
    }

    public RunnableObjImpl(Student b) {
        this.student = b;
    }

    public RunnableObjImpl(Student student, Integer num) {
        this.student = student;
        this.num = num;
    }

    @Override
    public void run() {
        TestThread.readLock.lock();
        student.setName(student.getName() + num);
        System.out.println("new threadBo : " + student);
        TestThread.readLock.unlock();
    }
}

class Student implements Serializable {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}