package Sort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.RunAOPInterface;
import Util.ArrayUtils;

public class BubbleSort implements RunAOPInterface {

    private static final int LENGTH_OF_ARRAY = 100000;
    @Override
    public Object run() {
        sort();
        return null;
    }

    public static void main(String[] args) {
        MyAOPTest.testRunTime(new BubbleSort());
    }
    public static void sort() {
        int times = 0;
        int[] a = ArrayUtils.initArray(LENGTH_OF_ARRAY);

//        ArrayUtils.printArray(a,"Init Array");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    ArrayUtils.swap(a, j, j + 1);
                    times++;
                }
            }
        }
//        ArrayUtils.printArray(a,"Sorted Array",times);

    }
}
