package LinkedList.Queue;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Entity.SingleNode;

/**
 * @author ZAXIE
 * @date 2023/10/6 13:27
 */
public class QuickSlowPointer implements MyRunAOPInterface {
    // static SingleNode odd;
    static SingleNode<Integer> odd;
    static SingleNode<Integer> even;

    public static void main(String[] args) {
        init();
        MyAOPTest.testRunTime(QuickSlowPointer.class);
    }

    private static void init() {
        odd = new SingleNode<>(0);
        odd.append(new Integer[]{1, 2, 3, 4, 5, 6});
        // odd.append("hello");
        odd.print();
        even = new SingleNode<>(0);
        even.append(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        even.print();
    }

    public void printHalfPointerUp() {
        SingleNode quick;
        SingleNode slow;
        System.out.print("odd : ");
        quick = odd;
        slow = odd;
        System.out.println(moveUp(quick, slow).value);
        System.out.print("even : ");
        quick = even;
        slow = even;
        System.out.println(moveUp(quick, slow).value);
    }

    public void printHalfPointerDown() {
        SingleNode quick;
        SingleNode slow;
        System.out.print("odd : ");
        quick = odd;
        slow = odd;
        System.out.println(moveDown(quick, slow).value);
        System.out.print("even : ");
        quick = even;
        slow = even;
        System.out.println(moveDown(quick, slow).value);
    }

    public void printUpHalfPointerUp() {
        SingleNode quick;
        SingleNode slow;
        System.out.print("odd : ");
        quick = odd;
        slow = odd;
        if (quick.next != null) {
            quick = quick.next.next;
        }
        System.out.println(moveUp(quick, slow).value);
        System.out.print("even : ");
        quick = even;
        slow = even;
        if (quick.next != null) {
            quick = quick.next.next;
        }
        System.out.println(moveUp(quick, slow).value);
    }

    public void printUpHalfPointerDown() {
        SingleNode quick;
        SingleNode slow;
        System.out.print("odd : ");
        quick = odd;
        slow = odd;
        if (quick.next != null) {
            quick = quick.next.next;
        }
        System.out.println(moveDown(quick, slow).value);
        System.out.print("even : ");
        quick = even;
        slow = even;
        if (quick.next != null) {
            quick = quick.next.next;
        }
        System.out.println(moveDown(quick, slow).value);
    }


    private SingleNode moveUp(SingleNode quick, SingleNode slow) {
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private SingleNode moveDown(SingleNode quick, SingleNode slow) {
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
