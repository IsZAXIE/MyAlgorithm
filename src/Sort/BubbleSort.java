package Sort;

import Utils.ArrayUtils;

public class BubbleSort {
    public static void main(String[] args) {
        int times = 0;
        int[] a = ArrayUtils.initArray(20);

        ArrayUtils.printArray(a,"Init Array");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    ArrayUtils.swap(a, j, j + 1);
                    times++;
                }
            }
        }
        ArrayUtils.printArray(a,"Sorted Array",times);

    }
}
