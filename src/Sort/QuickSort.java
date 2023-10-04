package Sort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Util.ArrayUtils;

import java.util.Arrays;

public class QuickSort implements MyRunAOPInterface {

    public final int ARRAY_LENGTH = 2000;

    static int count = 0;
    //    int[] to = ArrayUtils.initArray(ARRAY_LENGTH);
    int[] to = ArrayUtils.initOrderedArray(ARRAY_LENGTH);
//    int[] to = ArrayUtils.initArray(ARRAY_LENGTH,ARRAY_LENGTH/10);

    public static void main(String[] args) {
        MyAOPTest.testRunTime(QuickSort.class);
    }

    public void sort1() {

        int[] a = Arrays.copyOf(to, to.length);
        quickSort(a, 0, a.length);
        ArrayUtils.check(a, true);
    }

    public void sort2() {
        int[] a = Arrays.copyOf(to, to.length);
        quickSort2(a, 0, a.length);
        ArrayUtils.check(a, true);
    }


    /**
     * [minIndex,maxIndex)
     *
     * @param a        arrays
     * @param minIndex minIndex
     * @param maxIndex maxIndex
     */
    private void quickSort(int[] a, int minIndex, int maxIndex) {
        if (maxIndex - minIndex <= 1)  {
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


    /**
     * range : [minIndex , maxIndex)
     * Version 2.0 confirm block with same elements.
     * This optimization will really useful when there are too many repeat element
     *
     * @param a
     * @param minIndex
     * @param maxIndex
     */
    private void quickSort2(int[] a, int minIndex, int maxIndex) {
        if (maxIndex - minIndex <= 1) {
            return;
        }
        int less = minIndex;
        int great = maxIndex;
        int i = minIndex + 1;
        int reg = a[minIndex];
//        ArrayUtils.printArray(a, minIndex, maxIndex, "subArray " + minIndex + "  " + maxIndex + ":\t");
        while (i != great) {
            if (a[i] < reg) {
                // exchange a[i] with a[less]
                swap(a, i, less);
                less++;
                i++;
            } else if (a[i] == reg) {
                i++;
            } else if (a[i] > reg) {
                swap(a, i, great - 1);
                great--;
            }
        }
        quickSort2(a, minIndex, less);
//        System.out.println("minIndex = " + minIndex + "\tless = " + less);
        quickSort2(a, great, maxIndex);
//        System.out.println("great = " + great + "\tmaxIndex = " + maxIndex);

    }

    private void swap(int[] a, int firstIndex, int secondIndex) {
        int temp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = temp;
    }
}
