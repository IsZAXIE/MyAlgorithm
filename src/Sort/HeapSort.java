package Sort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Util.ArrayUtils;
import Util.ColorPrintUtils;

import java.util.Arrays;

import static Util.ArrayUtils.*;

// we needn't any additional area in heap sort the complex of area in heap sort is O(0)
public class HeapSort implements MyRunAOPInterface {
    static int time = 0;

    static int[] a;

    private final int LENGTH_OF_ARRAY = 100;
    /*
    @Override
    public Object run() {
        sort();
        bigRoot();
        return null;
    }
    */

    public static void main(String[] args) {
//        MyAOPTest.testRunTime(new HeapSort());
        MyAOPTest.testRunTime(HeapSort.class);
    }

    public void sort() {
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

    private int regular(int index, int tail) {
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
            if (a[index] < a[index * 2 + 1]) {
                ArrayUtils.swap(a, index, index * 2 + 1);
            }
            return index * 2 + 1;
        }
    }

    public void regularBigRoot() {
        int[] a = ArrayUtils.initArray(LENGTH_OF_ARRAY);
        initBigRootHeapOrdered(a);
    }

    public void regularBigRootByHeapify() {
        int[] a = ArrayUtils.initArray(LENGTH_OF_ARRAY);
        initBigRootHeapOrderedByHeapify(a);
    }

    private void initBigRootHeapOrdered(int[] a) {
        // ori: O(NlogN)
        for (int i = 0; i < a.length; i++) {
            // new elem is gt parent
            if (a[i] > a[(i - 1) / 2]) {
                exchange(a, i);
            }
        }
        ArrayUtils.checkHeap(a, true);
    }

    private void initBigRootHeapOrderedByHeapify(int[] a) {
        // optimize O(N)
        for (int i = a.length - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }

        ArrayUtils.checkHeap(a, true);
    }

    /**
     * core method in heap structure
     * this method is used to put node down and regulate balance tree into heap
     *
     * @param a
     * @param index®
     * @param size
     */
    private void heapify(int[] a, int index, int size) {
        int lcIndex = index * 2 + 1;
        while (lcIndex < size) {
            int rcIndex = lcIndex + 1;
            int largestIndex = rcIndex < size && a[rcIndex] > a[lcIndex] ? rcIndex : lcIndex;
            if (a[index] > a[largestIndex]) {
                break;
            }
            swap(a, index, largestIndex);
            index = largestIndex;
            lcIndex = index * 2 + 1;
        }
    }

    private void exchange(int[] a, int i) {
        // use non-recursion
        while (i != 0) {
            int parent = (i - 1) / 2;
            if (a[i] > a[parent]) {
                swap(a, i, parent);
                i = parent;
            } else {
                break;
            }
        }

        // use recursion
        /* int parentIndex = (i - 1) / 2;
        // exchange a[i] with his parent
        swap(a, i, parentIndex);
        // judge if his grand-pa is ge his parent
        if (a[parentIndex] > a[(parentIndex - 1) / 2]) {
            // if not exchange(a,hisParent)
            exchange(a, parentIndex);
        }
        */
    }

    // use small root heap to sort
    public void smallRootSortK() {
        // init array
        int[] a = new int[LENGTH_OF_ARRAY];
        final int k = 5;
        Arrays.fill(a, -1);
        for (int i = 0; i < a.length; i++) {
            int necessaryIndex = i - k;
            if (necessaryIndex >= 0 && a[necessaryIndex] == -1) {
                a[necessaryIndex] = i;
                continue;
            }
            // get available index for store 'i'
            // i must ge 0 and lt a.length
            int index = Math.min(Math.max(0, (int) (Math.random() * 2 * k + i - k)), a.length - 1);
            // if a[index] != -1 means a[index] is not available to store 'i'
            while (a[index] != -1) {
                // find available position to store 'i'
                index = ++index > Math.min(i + k, a.length - 1) ? Math.max(i - k, 0) : index;
            }
            a[index] = i;
        }
        checkK(a, k);

        // create a small root heap by index from '0-k'
        int[] smallRootHeap = Arrays.copyOf(a, Math.min(k + 1, a.length));

        // init small smallRootHeap
        for (int i = (smallRootHeap.length - 2) / 2; i >= 0; i--) {
            smallRootHeapify(smallRootHeap, i);
        }
        int[] result = new int[a.length];

        /**
         * first method : use index of array to calculate result.
         */
        /*
        for (int i = k + 1; i < a.length; i++) {
            result[i - k - 1] = smallRootHeap[0];
            smallRootHeap[0] = a[i];
            smallRootHeapify(smallRootHeap, 0);
        }
        // handle all from heap to result[]
        int size = smallRootHeap.length;
        // loop k times so heap has no element will never appear
        for (int i = a.length - 1 - k; i < result.length; i++) {
            result[i] = smallRootHeap[0];
            smallRootHeap[0] = smallRootHeap[size - 1];
            size--;
            smallRootHeapify(smallRootHeap, 0, size);
        }
        */

        /**
         * second method : use Integer.MAX_VALUE fill all position which has no extra element in a[]
         */
        for (int i = 0; i < result.length; i++) {
            result[i] = smallRootHeap[0];
            smallRootHeap[0] = i + k + 1 < a.length ? a[i + k + 1] : Integer.MAX_VALUE;
            smallRootHeapify(smallRootHeap, 0);
        }
        check(result, true);

    }

    /**
     * range is [0,size)
     */
    private void smallRootHeapify(int[] a, int rootIndex, int size) {
        if (size == 0) {
            return;
        }
        int lcIndex = rootIndex * 2 + 1;
        while (lcIndex < size) {
            int minChildIndex = lcIndex + 1 == size ? lcIndex : a[lcIndex] < a[lcIndex + 1] ? lcIndex : lcIndex + 1;
            if (a[minChildIndex] < a[rootIndex]) {
                swap(a, rootIndex, minChildIndex);
                rootIndex = minChildIndex;
                lcIndex = rootIndex * 2 + 1;
            } else {
                return;
            }
        }
    }


    private void smallRootHeapify(int[] a, int rootIndex) {
        smallRootHeapify(a, rootIndex, a.length);
    }

    private void checkK(int[] a, int k) {
        int[] temp = Arrays.copyOf(a, a.length);
        Arrays.sort(temp);
        int count = a.length;
        int tempIndex = a.length;
        for (int i = 0; i < a.length; i++) {
            tempIndex = Math.max(i - k, 0);
            while (a[tempIndex] != temp[i]) {
                if (++tempIndex == a.length) {
                    break;
                }
            }
            count = Math.abs(tempIndex - i);
        }
        if (count > k || tempIndex == a.length) {
            ColorPrintUtils.printRed("init error");
            ArrayUtils.printArray(a, "InitOutOfBounds : count = " + count + "\ttempIndex = " + tempIndex);
        } else {
            ColorPrintUtils.printGreen("InitCheck Pass");
            System.out.println();
        }
    }
}
