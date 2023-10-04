package Test.jvm;

import Entity.AOPInterface.MyRunAOPInterface;

/**
 * @author ZAXIE
 * @date 2023/9/28 08:33
 */
public class TestClassLoader implements MyRunAOPInterface {
    public static void main(String[] args) {
        Car car1 = new Car(1, "car1");
        Car car2 = new Car(2, "car2");
        Car car3 = new Car(3, "car3");
        Car car4 = new Car(4, "car4");
        Car car5 = new Car(5, "car5");

        // get class
        // from reflex
        try {
            Class<?> clz = Class.forName("TestClassLoader");
            Class<?> clz1 = Class.forName("TestClassLoader", true, TestClassLoader.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Car {
        int id;

        String Name;


        public Car() {
        }

        public Car(int id, String name) {
            this.id = id;
            Name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return Name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            Name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "id=" + id +
                    ", Name='" + Name + '\'' +
                    '}';
        }
    }
}
