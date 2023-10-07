package Entity;

import java.util.Stack;

/**
 * @author ZAXIE
 * @date 2023/8/27 16:53
 */
public class MyStack<T> {
    SingleNode root;

    public MyStack() {
    }

    public void push(T value) {
        if (root == null) {
            root = new SingleNode<>(value);
        } else {
            root = new SingleNode(value, root);
        }
    }


    /**
     * @return null if this stack has no element
     */
    public T pop() {
        if (root == null) {
            return null;
        } else {
            T value = (T) root.value;
            root = root.next;
            return value;
        }

    }


}
