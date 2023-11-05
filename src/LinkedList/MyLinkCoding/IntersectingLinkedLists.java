package LinkedList.MyLinkCoding;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Entity.SingleNode;
import Util.ColorPrintUtils;

import static Util.ColorPrintUtils.printGreen;
import static Util.ColorPrintUtils.printRed;
import static Util.NodeUtils.getLength;

/**
 * @author ZAXIE
 * @date 2023/11/5 14:16
 */
public class IntersectingLinkedLists implements MyRunAOPInterface {

    SingleNode<Integer> h1;
    SingleNode<Integer> h2;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(IntersectingLinkedLists.class);
    }

    public void findSame() {
        SingleNode<Integer> meet = initTwoSingleNode();
        System.out.println("meet = " + meet);
        SingleNode<Integer> same = judge();
        System.out.println("same = " + same + (same == null ? "" : "  value : " + same.value));
        if (same == meet) {
            printGreen("Pass");
        } else {
            printRed("Error");
        }
        System.out.println();
//        assert same == meet;
//        assert false;
    }

    private SingleNode<Integer> initTwoSingleNode() {
        int SIZE = 20;
        h1 = new SingleNode<>(0);
        SingleNode<Integer> temp = h1;
        boolean loopFlag = Math.random() * 10 >= 5;
        for (int i = 1; i < SIZE; i++) {
            temp.next = new SingleNode<>(i);
            temp = temp.next;
        }
        if (loopFlag) {
            int l = (int) (Math.random() * SIZE);
            SingleNode<Integer> loopFirst = h1;
            for (int i = l; i > 0; i--) {
                loopFirst = loopFirst.next;
            }
            temp.next = loopFirst;
        } else {
            temp.next = null;
        }
        System.out.println("H1:\tSize = " + SIZE + " \thas loop : " + loopFlag + (loopFlag ? (" \t loopFirst : " + temp.next + " value: " + (temp.next == null ? "null" : temp.next.value)) : ""));

        // init second nodeList
//        SIZE = 2;
        SIZE = (int) (Math.random() * 30 + 10);
        SingleNode<Integer> link = h1;

        boolean meetFlag = Math.random() < 0.1;
        if (!meetFlag) {
            h2 = new SingleNode<>(SIZE);
        } else {
            h2 = h1;
            System.out.println("H2 == H1");
            System.out.println("Meet: \tmeetPlace : " + h1 + "  value : " + (h1 == null ? "null" : h1.value));
            return h1;
        }
        SingleNode<Integer> h2Next = h2;
        for (int i = 1; i < SIZE; i++) {
            link = link.next == null ? h1 : link.next;
            meetFlag = Math.random() < 0.1;
            if (meetFlag) {
                h2Next.next = link;
                break;
            } else {
                h2Next.next = new SingleNode<>(i + SIZE);
                h2Next = h2Next.next;
            }
        }
        loopFlag = false;
        if (!meetFlag) {
            // create loop in h2?
            loopFlag = Math.random() * 10 >= 5;
            if (loopFlag) {
                int l = (int) (Math.random() * SIZE);
                SingleNode<Integer> loopFirst = h2;
                for (int i = l; i > 0; i--) {
                    loopFirst = loopFirst.next;
                }
                h2Next.next = loopFirst;
            } else {
                h2Next.next = null;
            }
        }
        System.out.println("H2:\tSize = " + SIZE + " \thas loop : \t" + loopFlag + (loopFlag ? (" \t loopFirst : " + h2Next.next + " value: " + (h2Next.next == null ? "null" : h2Next.next.value)) : ""));
        if (meetFlag) {
            System.out.println("Meet: \tmeetPlace : " + h2Next.next + "  value : " + (h2Next.next == null ? "null" : h2Next.next.value));
            return h2Next.next;
        }
        return null;
    }

    /**
     * find first node in circle
     *
     * @param head head of this list
     * @param <T>
     * @return first node in circle
     */
    private <T> SingleNode<T> findFirstNodeInCircle(SingleNode<T> head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        SingleNode<T> fast = head.next.next;
        SingleNode<T> slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private SingleNode<Integer> judge() {
        SingleNode<Integer> h1Circle = findFirstNodeInCircle(h1);
        System.out.println("h1Circle = " + h1Circle + (h1Circle == null ? "" : "  value : " + h1Circle.value));
        SingleNode<Integer> h2Circle = findFirstNodeInCircle(h2);
        System.out.println("h2Circle = " + h2Circle + (h2Circle == null ? "" : "  value : " + h2Circle.value));
        if (h1 == h2) {
            return h1;
        }
        if ((h1Circle == null ^ h2Circle == null)) {
            System.out.println("(h1^h2) = true ");
            return null;
        }
        // both of them are not null
        if (h1Circle != null
                // h1Circle and h2Circle maybe has same node before circleNode
                && (h1Circle != h2Circle)) {
            SingleNode next = h1Circle.next;
            while (next != h1Circle) {
                if (next == h2Circle) {
                    return h2Circle;
                }
                next = next.next;
            }
            return null;
        }
        // both of them are null or both of them point into same circleNode
        else {
            int h1Length = getLength(h1, h1Circle);
            int h2Length = getLength(h2, h2Circle);
            h1Circle = h1;
            h2Circle = h2;
            int sameLength = Math.min(h1Length, h2Length);
            for (int i = h1Length; i != sameLength; i--) {
                h1Circle = h1Circle.next;
            }
            for (int i = h2Length; i != sameLength; i--) {
                h2Circle = h2Circle.next;
            }
            while (h1Circle != h2Circle && h1Circle != null) {
                h1Circle = h1Circle.next;
                h2Circle = h2Circle.next;
            }
            return h1Circle;
        }

    }


}
