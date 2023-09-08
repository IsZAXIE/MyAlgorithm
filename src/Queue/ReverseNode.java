package Queue;

import Entity.DoubleNode;
import Entity.SingleNode;
import Util.NodeUtils;

public class ReverseNode {
    static final int NODE_LENGTH = 20;
    static final int NODE_START_VALUE = 1;

    public static void main(String[] args) {
        SingleNode singleHead = NodeUtils.initSingleNode(NODE_LENGTH);
        singleHead = reverseSingleNode(singleHead);
        NodeUtils.printSingleNode(singleHead, "Reversed SingleNodes : ");

        DoubleNode doubleHead = new DoubleNode(NODE_START_VALUE);
        DoubleNode doubleNail = NodeUtils.initDoubleNode(NODE_LENGTH, doubleHead);
        NodeUtils.printDoubleNode(doubleHead, doubleNail, "Ori DoubleNodes ");
        doubleNail=doubleHead;
//        doubleHead = reverseDoubleNode(doubleHead,doubleNail);
        doubleHead=reverseDoubleNode(doubleHead);
        System.out.println(doubleHead==doubleNail);
        NodeUtils.printDoubleNode(doubleHead, doubleNail, "Reversed DoubleNodes : ");
    }

    public static SingleNode reverseSingleNode(SingleNode head) {
        // a -> left, b-> mid, c->right
        SingleNode a = head;

        /**
         * Use This Code Block
         */
        /*
        if (a==null){
            return null;
        }

        SingleNode b=a.next;
        if(b==null){
            return  a;
        }
        a.next=null;
        SingleNode c=b.next;

        while(c!=null){
            b.next=a;

            a=b;
            b=c;
            c=c.next;
        }
        // handle end
        b.next=a;
        head =b;
        return head;
        */

        /**
         * Or this
         */
        SingleNode pre = null;
        SingleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    /**
     * @param head
     * @return new head of
     */
    public static final DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            // swap(pre, next)
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next; // the address of 'head' changed but the address of 'doubleHead' never changed
        }
        return pre;
    }
}
