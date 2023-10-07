package Test.classic;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Util.ArrayUtils;
import Util.ColorPrintUtils;

import static Util.ArrayUtils.swap;


/**
 * @author ZAXIE
 * @date 2023/10/6 15:02
 */
public class DutchFlagQuestion implements MyRunAOPInterface {

    public static void main(String[] args) {
        MyAOPTest.testRunTime(DutchFlagQuestion.class);
    }

    int[] a = ArrayUtils.initArray(200, 3,0);


    /**
     * range : [0,l)      [r,a.length)
     */
    public void partition() {
        int benchmark = 1;
        int l = 0;
        int r = a.length;
        for (int i = 0; i != r; i++) {
            if (a[i] > benchmark) {
                swap(a, --r, i);
                i--;
            } else if (a[i] < benchmark) {
                swap(a, l++, i);
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                ColorPrintUtils.printRed("\nerror i = " + i + "\n");
                return;
            }
        }
        ColorPrintUtils.printGreen("Pass\n");
    }
}
