package Test;

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
        System.out.println("a == b\t" + (a == b)); // compare the address of "test" in the heap with another "test" in the same address of heap
        System.out.println("a == c\t" + (a == c)); // first merge "te" and "st" and point to "test" in the heap and then compare the address of "test" in the heap with another "test" in the same address of heap
        System.out.println("a == d\t" + (a == d)); // First, you need to apply for a memory address to store "test", and then compare the address of "test" in the heap with the address of "test" in the memory.
        System.out.println("a == e\t" + (a == e)); // same with (a == d)
        System.out.println("c == e\t" + (c == e)); // same with (a == d)
        System.out.println("d == e\t" + (d == e)); // First, you need to apply for two memory address to store "test" and "test" merged then compare the address of "test" in memory with another "test" in the different address of memory
    }
}
