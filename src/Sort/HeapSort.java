package Sort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.ParentsInterface;
import Util.ArrayUtils;

import static Util.ArrayUtils.initArray;
import static Util.ArrayUtils.swap;

public class HeapSort implements ParentsInterface {
    static int time = 0;

    static int[] a;

    private static final int LENGTH_OF_ARRAY = 1000000;

    @Override
    public Object run() {
        sort();
        return null;
    }

    public static void main(String[] args) {
        MyAOPTest.testRunTime(new HeapSort());
    }

    public static void sort() {
         a = ArrayUtils.initArray(LENGTH_OF_ARRAY);
//        ArrayUtils.printArray(a, "Origin : ");
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
//        ArrayUtils.printArray(a, "init");
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
//        ArrayUtils.printArray(a, "排序后数组", time);
        ArrayUtils.check(a, true);
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
            if(a[index]<a[index*2+1]) {
                ArrayUtils.swap(a, index, index*2+1);
            }
            return index*2+1;
        }
    }
}
