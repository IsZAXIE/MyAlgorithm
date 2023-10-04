package Sort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Util.ArrayUtils;

/**
 * @author ZAXIE
 * @date 2023/9/24 12:22
 */
public class InsertSort implements MyRunAOPInterface {
    public static void main(String[] args) {
        MyAOPTest.testRunTime(InsertSort.class);
    }

    public void sort() {
        int[] a = ArrayUtils.initArray(2000);
        insertSort(a);
        ArrayUtils.check(a, true);

    }

    private void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= -1; j--) {
                // j == -1 :
                if (j == -1) {
                    a[0] = temp;
                    break;
                }
                // gt temp : move back
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                    continue;
                }
                // se temp : insert temp into j+1
                if (a[j] <= temp) {
                    a[j + 1] = temp;
                    continue;
                }
            }
        }
    }
}
