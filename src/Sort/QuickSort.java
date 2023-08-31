package Sort;

import Util.ArrayUtils;

public class QuickSort {

    static int count = 0;

    public static void main(String[] args) {
        int[]a = ArrayUtils.initArray(20);

        ArrayUtils.printArray(a, "Original Array : ");
        quickSort(a, 0, a.length);
        ArrayUtils.printArray(a, "Sorted Array : ",count);
    }

    /**
     * [minIndex,maxIndex)
     *
     * @param a        arrays
     * @param minIndex minIndex
     * @param maxIndex maxIndex
     */
    private static void quickSort(int[] a, int minIndex, int maxIndex) {
        if (maxIndex - minIndex <= 1) {
            return;
        }
        int empty = minIndex;
        int benchmark = a[empty];
        int minT = minIndex;
        int maxT = maxIndex - 1;
        while (minT != maxT) {
            if (empty == minT) {
                // compare a[maxT] to benchmark
                if (a[maxT] < benchmark) {
                    // move
                    count++;
                    a[empty] = a[maxT];
                    empty = maxT;
                    minT++;
                } else {
                    maxT--;
                }
            } else {
                if (a[minT] > benchmark) {
                    // move
                    count++;
                    a[empty] = a[minT];
                    empty = minT;
                    maxT--;
                } else {
                    minT++;
                }
            }
        }
        a[minT] = benchmark;

//        ArrayUtils.printArray("mid : ",a);
        quickSort(a, minIndex, empty);
        quickSort(a, empty + 1, maxIndex);
    }
}
