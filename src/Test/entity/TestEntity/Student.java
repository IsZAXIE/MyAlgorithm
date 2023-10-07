package Test.entity.TestEntity;

/**
 * @author ZAXIE
 * @date 2023/10/7 09:10
 */
public class Student {

    private static int count;
    private String name;
    private int id;

    public Student() {
    }


    public Student(String name) {
        this.id = ++count;
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
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}
