package Utils;

import Entity.DoubleNode;
import Entity.SingleNode;

import java.util.Map;

public class NodeUtils {
    public static SingleNode initSingleNode(int length) {
        if (length <= 0) {
            return null;
        }
        SingleNode head = new SingleNode(1);
        SingleNode temp = head;
        for (int i = 1; i < length; i++) {
            SingleNode singleNode = new SingleNode(i + 1);
            temp.next = singleNode;
            temp = temp.next;
        }
        return head;
    }

    public static void printSingleNode(SingleNode head) {
        SingleNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static final void printSingleNode(SingleNode head, String note) {
        System.out.print(note + " ");
        printSingleNode(head);
    }


    public static final DoubleNode initDoubleNode(int length) {
        if (length <= 0) {
            return null;
        }
        // just use for statement to init doubleNodeLinkedList
        DoubleNode next = null;
        DoubleNode head = null;
        for (int i = length; i > 0; i++) {
            head = new DoubleNode(i);
            head.next = next;
            head.pre = null;
            next.pre = head;
            next = head;
        }
        return head;
    }


    /**
     * @param length length of list
     * @param head   not null
     * @return tail of list
     */
    public static final DoubleNode initDoubleNode(int length, DoubleNode head) {
        if (length <= 0) {
            return null;
        }
        DoubleNode tmp = head;
        for (int i = 1; i < length; i++) {
            DoubleNode nail;
            nail = new DoubleNode(i + head.value);
            tmp.next = nail;
            nail.pre = tmp;
            tmp = nail;
        }
        return tmp;
    }


    public static void printDoubleNode(DoubleNode node, Boolean sequential) {
        DoubleNode temp = node;
        if (sequential) {
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        } else {
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.pre;
            }
        }
        System.out.println();
    }

    public static void printDoubleNode(DoubleNode head, DoubleNode nail, String s) {
        System.out.println(s);
        System.out.print("\t In order ( head -> nail ) : ");
        printDoubleNode(head, true);
        System.out.print("\t Reverse order ( nail -> head ) : ");
        printDoubleNode(nail, false);
    }

    public static SingleNode initRandomSingleNode(int nodeListLength, int range, int min) {
        if (nodeListLength <= 0) {
            return null;
        }

        SingleNode head = new SingleNode((int) (Math.random() * range) + min);
        SingleNode temp = head;
        for (int i = 0; i < nodeListLength - 1; i++) {
            temp.next = new SingleNode((int) (Math.random() * range) + min);
            temp = temp.next;
        }
        return head;
    }

    public static SingleNode initRandomSingleNode(int nodeListLength, int range) {
        return initRandomSingleNode(nodeListLength, range, 0);
    }

    public static SingleNode initRandomSingleNode(int nodeListLength) {
        return initRandomSingleNode(nodeListLength, (int) (nodeListLength * 1.5));
    }

    public static void printStack(SingleNode head, String note) {
        printSingleNode(head, note + " Stack : ");
    }
}
