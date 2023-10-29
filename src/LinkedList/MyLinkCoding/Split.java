package LinkedList.MyLinkCoding;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Entity.SingleNode;
import Util.ArrayUtils;
import Util.NodeUtils;

/**
 * @author ZAXIE
 * @date 2023/10/29 14:44
 */
public class Split implements MyRunAOPInterface {
    private static final int LENGTH = 20;
    private static final int RANGE = 10;
    private static final int MIN = 0;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(Split.class);
    }

    public void testSplit() {
        Integer[] tempInitArray = ArrayUtils.initIntegerArray(LENGTH, RANGE, MIN);
        SingleNode<Integer> head = new SingleNode<>(tempInitArray);
        NodeUtils.printSingleNode(head, "Original nodes: length = " + NodeUtils.getLength(head) + "\t");
        int mid;
//        mid = 9;
        mid = (int) (Math.random() * RANGE + MIN);
        System.out.println("mid = " + mid);

        SingleNode sH = null;
        SingleNode sT = null;
        SingleNode eH = null;
        SingleNode eT = null;
        SingleNode gH = null;
        SingleNode gT = null;
        while (head != null) {
            SingleNode next = head.next;
            if (head.value < mid) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
                sT.next = null;
            } else if (head.value == mid) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
                eT.next = null;
            } else {
                if (gH == null) {
                    gH = head;
                    gT = head;
                } else {
                    gT.next = head;
                    gT = gT.next;
                }
                gT.next = null;

            }
            head = next;
        }
        NodeUtils.printSingleNode(sH, "Small part: ");
        NodeUtils.printSingleNode(eH, "Equals part: ");
        NodeUtils.printSingleNode(gH, "Great part: ");

        System.out.println();
        /**
         * Link again
         */
        /*
        // linked by separate node
        // connect st->eH
        if (sH != null) {
            sT.next = eH;
            eT = eH == null ? sT : eT;
        }
        // connect eT->gH
        if (eT != null) {
            eT.next = gH;
        }
        head = sH != null ? sH : (eH != null ? eH : gH);
        */
        // link by head
        SingleNode tail = null;
        if (sH != null) {
            head = sH;
            tail = sT;
        }
        if (eH != null) {
            if (head == null) {
                head = eH;
                tail = eT;
            } else {
                tail.next = eH;
                tail = eT;
            }
        }
        if (gH != null) {
            if (head == null) {
                head = gH;
            } else {
                tail.next = gH;
            }
        }


        NodeUtils.printSingleNode(head, "New nodes: length = " + NodeUtils.getLength(head) + "\t");


    }
}
