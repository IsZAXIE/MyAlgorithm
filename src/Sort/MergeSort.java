package Sort;

import AOPTest.MyAOPTest;
import Entity.ParentsInterface;
import Utils.ArrayUtils;

/**
 * @author ZAXIE
 * @date 2023/8/30 20:16
 */
public class MergeSort implements ParentsInterface {
    static int[] a;
    static int ARRAY_LENGTH = 8000;

    @Override
    public Object run() {
        sort();
        return null;
    }

    public static void main(String[] args) {
        MyAOPTest.testRunTime(new MergeSort());

    }

    private static void sort() {
//        a = ArrayUtils.initDescArray(ARRAY_LENGTH);
        a = ArrayUtils.initArray(ARRAY_LENGTH,ARRAY_LENGTH);
//        ArrayUtils.printArray(a, "Before Sort : ");
        recursion(0, a.length);
//        ArrayUtils.printArray(a, "After Sort : ");
        ArrayUtils.check(a, true);
    }

    // [l,r)
    public static final void recursion(int l, int r) {
        if (r - l == 1) {
//            ArrayUtils.printSplit(a, l, r, "l = " + l + " , r = " + r + "\t");
            return;
        }
        if (r - l == 2) {
            if (a[l] > a[r - 1]) {
                ArrayUtils.swap(a, l, r - 1);
            }
//            ArrayUtils.printSplit(a, l, r, "l = " + l + " , r = " + r + "\t");
            return;
        }

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
        int[] temp=new int[r-l];
        int tempL=l,tempR=mid;
        for(int i=0;i<temp.length;i++){
            if(tempL==mid){
                temp[i]=a[tempR];
                tempR++;
                continue;
            }
            if(tempR==r){
                temp[i]=a[tempL];
                tempL++;
                continue;
            }

            if(a[tempL]<=a[tempR]){
                temp[i]=a[tempL];
                tempL++;
            }
            else {
                temp[i]=a[tempR];
                tempR++;
            }
        }
        for(int i=l;i<r;i++){
            a[i]=temp[i-l];
        }
//        ArrayUtils.printSplit(a,l,r,"l = "+l+" , r = "+r+"\t");
    }
}
