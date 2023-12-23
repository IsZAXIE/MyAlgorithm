package Test.base;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;

/**
 * @author ZAXIE
 * @date 2023/11/18 13:11
 */
public class BitwiseOperatorTest implements MyRunAOPInterface {
    public static void main(String[] args) {
        MyAOPTest.testRunTime(BitwiseOperatorTest.class);
    }

    public void testOperator() {
        // all of bit operator won't change original parameter.
        // << and >> will move all bit exclude signed and add 0 in the blank space
        // >>> will move all bit including signed and add 0 into leftmost place 
        // from doc :
        // The signed left shift operator "<<" shifts a bit pattern to the left, and the signed right shift operator ">>" shifts a bit pattern to the right.
        // The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand.
        // The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.
        int i = -2;
        for (int j = 0; j < 2; j++) {
            System.out.println(i >> 1);
            System.out.println(i >>> 1);
            System.out.println(i << 1);
            System.out.println();
//            System.out.println(i << 1);
        }
    }
}
