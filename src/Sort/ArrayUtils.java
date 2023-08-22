package Sort;

import java.util.Arrays;

public class ArrayUtils {

    public static int[] initArray(int length, int range) {
        int[] a = new int[length];
        initArray(a, range, 0);
        return a;
    }

    public static int[] initArray(int length) {
        return initArray(length, (int) (length * 1.5));
    }


    public static void initArray(int[] a, int range, int min) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * range) + min;
        }
    }

    public static void initArray(int[] a, int range) {
        initArray(a, range, 0);
    }

    public static void initArray(int[] a) {
        initArray(a, (int) (a.length * 1.5));
    }

    public static void printArray(int[] a, String note) {
        System.out.print(note + '\t');
        printArray(a);
    }

    public static void printArray(int[] a, String note, int count) {
        System.out.print("changeTimes : " + count + '\t');
        printArray(a, note);
    }

    public static void printArray(String note, int[] a) {
        System.out.print(note + '\t');
        printArray(a);
    }

    public static void printArray(String note, int[] a, int count) {
        System.out.print("changeTimes : " + count + '\t');
        printArray(a);
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int index1,int index2){
        int temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }

}
