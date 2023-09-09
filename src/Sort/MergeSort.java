package Sort;

import AOPTest.MyAOPTest;
import Entity.ParentsInterface;
import Util.ArrayUtils;


/**
 * 注 : +  运算优先级高于 >>, <<
 */

/**
 * @author ZAXIE
 * @date 2023/8/30 20:16
 */
public class MergeSort implements ParentsInterface {
    static int[] a;
    static int ARRAY_LENGTH = 80000;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(MergeSort.class);
    }

    public void sort() {
//        a = ArrayUtils.initDescArray(ARRAY_LENGTH);
        a = ArrayUtils.initArray(ARRAY_LENGTH, ARRAY_LENGTH);
//        ArrayUtils.printArray(a, "Before Sort : ");
        recursion(0, a.length);
//        ArrayUtils.printArray(a, "After Sort : ");
        ArrayUtils.check(a, true);
    }

    // [l,r)
    private void recursion(int l, int r) {
        if (r - l == 1) {
//            ArrayUtils.printSplit(a, l, r, "l = " + l + " , r = " + r + "\t");
            return;
        }
        /*if (r - l == 2) {
            if (a[l] > a[r - 1]) {
                ArrayUtils.swap(a, l, r - 1);
            }
//            ArrayUtils.printSplit(a, l, r, "l = " + l + " , r = " + r + "\t");
            return;
        }*/

        // split
//         int mid = (l + r) / 2.0 > Math.floor((l + r) / 2) ? (int) Math.ceil((l + r) / 2) : (l + r) / 2 + 1;
        int mid = (l + r) / 2;
        recursion(l, mid);
        recursion(mid, r);

        // merge
        /**
         * this block are wrong!!
         */
        /*
        int tempL = l, tempR = mid, tempMid = mid;
        while (tempR != r) {
            if (tempMid == tempR) {
                // compare tempL with tempR
                if (a[tempL] <= a[tempR]) {
                    tempL++;
                }
                if (a[tempR] < a[tempL]) {
                    ArrayUtils.swap(a, tempL, tempMid);
                    tempR++;
                    tempL++;
                }
            } else if (tempR != tempMid) {
                if (a[tempR] <= a[mid]) {
                    ArrayUtils.swap(a, tempL, tempR);
                    tempL++;
                    tempR++;
                } else {
                    ArrayUtils.swap(a, tempL, tempMid);
                    tempL++;
                }
            }
        }
        ArrayUtils.printSplit(a, l, r, "l = " + l + " , r = " + r + "\t");
         */

        /**
         * Use another space to merge array
         */
        int[] temp = new int[r - l];
        int tempL = l, tempR = mid;
        for (int i = 0; i < temp.length; i++) {
            if (tempL == mid) {
                while (tempR != r) {
                    temp[i++] = a[tempR++];
                }
                break;
            }
            if (tempR == r) {
                while (tempL != mid) {
                    temp[i++] = a[tempL++];
                }
                break;
            }

            if (a[tempL] <= a[tempR]) {
                temp[i] = a[tempL];
                tempL++;
            } else {
                temp[i] = a[tempR];
                tempR++;
            }
        }
        for (int i = l; i < r; i++) {
            a[i] = temp[i - l];
        }
//        ArrayUtils.printSplit(a,l,r,"l = "+l+" , r = "+r+"\t");
    }

    public final void non_recursionSort() {
        a = ArrayUtils.initArray(ARRAY_LENGTH, ARRAY_LENGTH);
        int length = a.length;
        int mergeNum = 0;
//        ArrayUtils.printArray(a, "original array : ");
        while (mergeNum <= length) {
            int l = 0;
            if (mergeNum == 0) {
                mergeNum++;
            } else {
                mergeNum <<= 1;
            }
            // on one side ? continue : go on
            while (l + mergeNum < length) {
                // find right and merge
                int r = Math.min(l + (mergeNum<<1), length);
                merge(l, mergeNum, r);
                l = r;
            }
//            ArrayUtils.printArray(a, "middle : ", mergeNum);
        }
        ArrayUtils.check(a, true);
    }

    /**
     * [l,r)
     *
     * @param l
     * @param mergeNum
     * @param r
     */
    public final void merge(int l, int mergeNum, int r) {
        int[] temp = new int[r - l];
        int tempL = l;
        int mid = l + mergeNum, tempR = mid, i = 0;
        while (tempL != mid && tempR != r) {
            if (a[tempL] <= a[tempR]) {
                temp[i++] = a[tempL++];
            } else {
                temp[i++] = a[tempR++];
            }
        }
        while (tempL != mid) {
            temp[i++] = a[tempL++];
        }
        while (tempR != r) {
            temp[i++] = a[tempR++];
        }
//        ArrayUtils.printArray(temp,"move : ");
        for (i = 0; i < temp.length; i++) {
            a[l + i] = temp[i];
        }
    }
}
