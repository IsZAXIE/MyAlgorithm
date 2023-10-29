package LinkedList.MyLinkCoding;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Util.ColorPrintUtils;

import java.util.HashMap;
import java.util.Map;

import static Util.ColorPrintUtils.printGreen;

/**
 * @author ZAXIE
 * @date 2023/10/29 18:16
 */
public class CopyNodeWithRandom implements MyRunAOPInterface {

    RandomNode oriHead;

    public static void main(String[] args) {
        MyAOPTest.testRunTime(CopyNodeWithRandom.class);
    }

    private void initNodes() {
        int size = 10;
        RandomNode[] arr = new RandomNode[size + 1];
        for (int i = 0; i < size; i++) {
            arr[i] = new RandomNode(i);
        }
        for (int i = 0; i < size; i++) {
            arr[i].next = arr[i + 1];
            arr[i].rand = arr[(int) (Math.random() * size + 1)];
        }
        oriHead = arr[0];
    }

    private static class RandomNode {
        int value;
        RandomNode next;
        RandomNode rand;

        public RandomNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "RandomNode{" +
                    "value=" + value +
                    ", next=" + (next == null ? "null" : next.value) +
                    ", rand=" + (rand == null ? "null" : rand.value) +
                    '}';
        }
    }

    private void printRandomNodes(RandomNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        /*RandomNode temp = head;
        while (temp != null) {
            System.out.println("\t" + temp);
            temp = temp.next;
        }*/
        while (head != null) {
            System.out.println("\t" + head);
            head = head.next;
        }
    }

    private void printRandomNodes(RandomNode head, String note) {
        System.out.println(note);
        printRandomNodes(head);
    }

    private void check(RandomNode ori, RandomNode copy) {
        while (ori != null || copy != null) {
            if ((ori == null || copy == null || ori.value != copy.value) && ori != copy) {
                ColorPrintUtils.printRed("Not Equals");
                return;
            } else {
                ori = ori.next;
                copy = copy.next;
            }
        }
        printGreen("Equals");
    }

    private void check(RandomNode ori, RandomNode copy, String note) {
        printRandomNodes(copy, "copyNodes: ");
        System.out.print(note + "\t");
        check(ori, copy);
        System.out.println();
    }

    public void copyNodeWithRandom() {
        initNodes();
        printRandomNodes(oriHead, "ori Nodes : ");
        RandomNode hNode = copyByHashMap();
        check(oriHead, hNode, "HashMapCopy: ");
        RandomNode lNode = copyByOriLink(hNode);
        printRandomNodes(hNode, "hNode : ");
        check(hNode, lNode, "HashMapCopy: ");
    }

    private RandomNode copyByHashMap() {
        if (oriHead == null) {
            return null;
        }
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode temp = oriHead;
        while (temp != null) {
            map.put(temp, new RandomNode(temp.value));
            temp = temp.next;
        }
        temp = oriHead;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).rand = map.get(temp.rand);
            temp = temp.next;
        }
        return map.get(oriHead);
    }

    private RandomNode copyByOriLink(RandomNode head) {
        RandomNode temp = head;

        // copy next and value
        while (temp != null) {
            RandomNode next = temp.next;
            temp.next = new RandomNode(temp.value);
            temp.next.next = next;
            temp = next;
        }

        // handle rand
        temp = head;
        while (temp != null) {
            temp.next.rand = temp.rand == null ? null : temp.rand.next;
            temp = temp.next.next;
        }

        // split original nodes
        RandomNode h = head.next;
        temp = h.next;
        RandomNode tempH = h;
        RandomNode tempHead = head;
        while (temp != null) {
            tempHead.next = temp;
            tempH.next = temp.next;
            tempHead = tempHead.next;
            tempH = tempH.next;
            temp = temp.next.next;
        }
        tempHead.next = null;
        return h;
    }
}
