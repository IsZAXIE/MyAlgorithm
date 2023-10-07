package Test.base;

/**
 * @author ZAXIE
 * @date 2023/9/18 15:06
 */
public class TestStringAddress {
    public static void main(String[] args) {
        String a = "test";
        String b = "test";
        String c = "te" + "st";
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        String d = sb.toString();
        sb.delete(0, sb.length());
        sb.append("te").append("st");
        String e = sb.toString();
        // compare the address of constant "test" in the heap with another constant "test" in the same address of heap
        // all of const String has same value are at the same place of heap
        System.out.println("a == b\t" + (a == b));
        // first merge "te" and "st" and point to the constant "test" in the heap and then compare the address of the constant "test" in the heap with another "test" at the same address of heap
        System.out.println("a == c\t" + (a == c));
        // First, you need to apply for a memory address in the heap to store "test", and then compare the address of "test" in the heap with the address of "test" in the memory.
        System.out.println("a == d\t" + (a == d));
        // same with (a == d)
        System.out.println("a == e\t" + (a == e));
        // same with (a == d)
        System.out.println("c == e\t" + (c == e));
        // First, you need to apply for two different memory address in the heap to store "test" and "test" merged then compare the address of "test" in memory with another "test" in the different address of memory
        System.out.println("d == e\t" + (d == e));
    }
}
