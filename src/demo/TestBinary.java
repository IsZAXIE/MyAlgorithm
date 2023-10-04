package demo;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;

/**
 * @author ZAXIE
 * @date 2023/9/26 08:28
 */
public class TestBinary implements MyRunAOPInterface {
    long num = 36608;
    long index = 15;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(TestBinary.class);
    }

    /**
     * this result is equals but not strictly.
     */
    public void split() {
        long ori=num;
        if (num <= 0) {
            System.out.println(num + " < 2^(0)");
            return;
        }
        StringBuffer sb = new StringBuffer();
        int count = -1;
        String str;
        str = Long.toBinaryString(num);
        while (num != 0) {
            num >>= 1;
            str = Long.toBinaryString(num);
            count++;
        }
        sb.append(num).append(" = 2^(").append(count).append(")\taka : ");
        String[] units = {"B", "KB", "MB", "GB", "TB"};

        sb.append(String.format("%.0f", Math.pow(2, count % 10))).append(units[count / 10]);
        sb.append(String.format("\tcalculate %.0f less", ori-(Math.pow(2, count) - num)));

        System.out.println(sb);
    }

    public void synthesis() {
        long result = (long) Math.pow(2, index);
        System.out.println("2^(" + index + ") = " + result);
    }
}
