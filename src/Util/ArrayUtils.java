package Util;

import java.util.Arrays;

public class ArrayUtils {


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

    public static int[] initDescArray(int length) {
        int[] a = new int[length];
        for (int i = length; i > 0; i--) {
            a[length - i] = i;
        }
        return a;
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

    public static int[] initOrderedArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = i;
        }
        return a;
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

    public static void printArray(int[] a, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            if ((i) % 5 == 0) {
                System.out.println();
                System.out.print("\t");
            }
            System.out.printf("%5d", a[i]);
        }
        System.out.println();
    }

    public static void printArray(int[] a, int startIndex, int endIndex, String note) {
        System.out.println(note + "\t:");
        System.out.print("\t");
        printArray(a, startIndex, endIndex);
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void check(int[] a, boolean esc) {
        if (esc) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    pass(false);
                    if (a.length <= 20) {
                        System.out.println();
                        printArray(a);
                        System.out.println();
                    }
                    return;
                }
            }
        } else {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    pass(false);
                    return;
                }
            }
        }
        pass(true);
    }

    private static void pass(boolean pass) {
        if (pass) {
            ColorPrintUtils.printGreen("Pass");
        } else {
            ColorPrintUtils.printRed("Error");
        }
        System.out.println();
    }

    // [l,r)
    public static void printSplit(int[] a, int l, int r) {
        for (int i = 0; i < a.length; i++) {
            if (i == l) {
                System.out.print("「");
            }
            System.out.print(a[i] + "  ");
            if (i == r - 1) {
                System.out.print("」");
            }

        }
        System.out.println();
    }

    public static void printSplit(int[] a, int l, int r, String note) {
        System.out.print(note);
        printSplit(a, l, r);
    }
}
