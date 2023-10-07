package Sort.BucketSort;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;

/**
 * @author ZAXIE
 * @date 2023/10/4 18:28
 */

/**
 * countSort only efficient when the range of data are narrow eg: age(0-200)
 */
public class CountSort implements MyRunAOPInterface {
    public static void main(String[] args) {
        MyAOPTest.testRunTime(CountSort.class);
    }

    public void sort() {
    }

}
