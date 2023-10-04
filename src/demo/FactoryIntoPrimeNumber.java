package demo;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;

/**
 * @author ZAXIE
 * @date 2023/9/26 08:08
 */
public class FactoryIntoPrimeNumber implements MyRunAOPInterface {
    final int number = 100;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(FactoryIntoPrimeNumber.class);
    }

    public void factoring() {
        int input = number;
        if (input <= 0) {
            System.out.println(" input < 0");
            return;
        }
        int i = 2;
        StringBuffer sb = new StringBuffer();
        while (input != 1) {
            if (input % i == 0) {
                sb.append(i + "  ");
                input = input / i;
                i=2;
            }
            else {
                i++;
            }
        }
        System.out.println(sb);
    }
}
