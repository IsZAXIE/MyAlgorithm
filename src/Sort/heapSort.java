package Sort;

import Utils.ArrayUtils;

import static Utils.ArrayUtils.initArray;
import static Utils.ArrayUtils.swap;

public class heapSort {
    static int time = 0;

    static int[] a;

    public static void main(String[] args) {
         a = ArrayUtils.initArray(20);
//        a = new int[]{0, 27, 22, 24, 29, 16, 6, 13, 9, 5, 10, 7, 26, 2, 12, 25, 10, 2, 9, 10};
        ArrayUtils.printArray(a, "Origin : ");
        // create heap
        for (int i = a.length - 1; i > 0; i--) {
            // parent is (index-1)/2
            if (a[i] > a[(i - 1) / 2]) {
                swap(a, i, (i - 1) / 2);
            }
            int temp = i;
            while (temp != -1) {
                temp = regular(temp, a.length);
            }
        }
        ArrayUtils.printArray(a, "init");
        int tail = a.length - 1;
        while (tail > 0) {
            swap(a, 0, tail);
            int temp = 0;
            while (temp != -1) {
                temp = regular(temp, tail);
            }
            tail--;
//            ArrayUtils.printArray(a, "" + tail);
        }
        ArrayUtils.printArray(a, "排序后数组", time);
        ArrayUtils.pass(ArrayUtils.check(a, true));
    }

    /*
    private static int regular(int index, int tail) {
        int newIndex = -1;
        if (index * 2 + 1 < tail && a[index * 2 + 1] > a[index]) {
            time++;
            swap(a, index, index * 2 + 1);
            newIndex = index * 2 + 1;
        }
        if (index * 2 + 2 < tail && a[index * 2 + 2] > a[index]) {
            time++;
            swap(a, index, index * 2 + 2);
            newIndex = newIndex == -1 ? index * 2 + 2 : newIndex;
        }
        return newIndex;
    }
    */

    private static int regular(int index, int tail) {
        // out of bound
        if (index * 2 + 1 >= tail) {
            time++;
            return -1;
        }
        // compare two child
        else if (index * 2 + 2 < tail) {
            time++;
            int i = a[index * 2 + 1] > a[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;
            if (a[index] < a[i]) {
                time++;
                ArrayUtils.swap(a, index, i);
                return i;
            }
            return -1;
        }
        // change immediately
        else {
            time++;
            ArrayUtils.swap(a, index, index*2+1);
            return index*2+1;
        }
    }
}
