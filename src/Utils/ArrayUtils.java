package Utils;

import java.util.Arrays;

public class ArrayUtils {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";


    /*
   public static void main(String[] args) {
        System.out.println(RED + "This is a red text" + RESET);
        System.out.println(GREEN + "This is a green text" + RESET);
    }
    */


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

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static boolean check(int[] a, boolean esc) {
        if (esc) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    return false;
                }
            }
        }
        else {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void pass(boolean pass){
        if(pass){
            System.out.println(GREEN+"Pass"+RESET);
        }
        else {
            System.out.println(RED+"ERROR"+RESET);
        }
    }
}
