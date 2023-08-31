package Stack;

import Entity.SingleNode;
import Utils.NodeUtils;

public class MyStack {
    static SingleNode stack = null;

    static final int STACK_SIZE = 20;

    public static final SingleNode initStack(int size) {
        if (size <= 0) {
            return null;
        }
        SingleNode head = null;
        for (int i = 0; i < size; i++) {
            SingleNode temp = head;
            head = new SingleNode(1 + i);
            head.next = temp;
        }
        return head;
    }
    public static void main(String[] args) {

        stack = initStack(STACK_SIZE);
        NodeUtils.printStack(stack, "Ori ");
        push(21);
        push(22);
        push(23);
        push(24);
        push(25);
        push(26);
        System.out.println(pop().value);
        NodeUtils.printStack(stack, "After ");
    }

    public static final void push(int value) {
        SingleNode newHead = new SingleNode(value);
        newHead.next = stack;
        stack = newHead;
    }

    public static final SingleNode pop() {
        SingleNode tmp = stack;
        stack = stack.next;
        return tmp;
    }
}
