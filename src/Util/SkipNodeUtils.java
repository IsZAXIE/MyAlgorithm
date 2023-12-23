package Util;

import Entity.SkipNode;

import java.util.Comparator;

/**
 * @author ZAXIE
 * @date 2023/11/17 15:38
 */
public class SkipNodeUtils<T> {

    /**
     * Root Node
     */
    private SkipNode<T> root;

    /**
     * length of Node List
     */
    private int length;

    /**
     * height of this List
     */
    private int floor;

    /**
     * how to compare T1 with T2
     */
    private Comparator<T> comparator;

    public SkipNodeUtils() {
    }

    public SkipNodeUtils(SkipNode<T> root, Comparator<T> comparator) {
        this.root = root;
        this.comparator = comparator;
        length = getLength();

    }

    private int getLength() {
        int length = 0;
        if (root == null) {
            return 0;
        }

        SkipNode<T> temp = root;
        while (temp.down != null) {
            temp = temp.down;
        }
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    public void add(SkipNode<T> insNode) {
        int newHigh;
        if (insNode == null) {
            return;
        }

        length++;
        if (root == null) {
            root = insNode;
            return;
        }

        SkipNode<T> node = root;
        while (true) {
            SkipNode<T> next = node.next;
            if (node.down != null) {
                // haven't arrived last row
                if (comparator.compare(next.value, insNode.value) < 0) {
                    node = next;
                    continue;
                }
                node = node.down;
            } else {
                // have reached last row
                if (comparator.compare(next.value, insNode.value) < 0) {
                    // create head node
                    insNode.next = node;
                    // judge if need to create a new row

                }
            }

        }


    }

    private int randomLevel(int min) {
        int level = min;
        int len = length;
        for (int i = 0; len != 0; i++) {
            if (1<Math.pow(2,i)){
                level = Math.max(i, level);
            }
            len = len >> 1;
        }
        return level;
    }

    public boolean hasValue(T value) {
        SkipNode<T> node = root;
        while (node != null) {
            SkipNode<T> next = node.next;
            if (comparator.compare(node.value, value) == 0) {
                return true;
            }
            if (next == null) {
                node = node.down;
                continue;
            }
            if (comparator.compare(next.value, value) < 0) {
                node = next;
                continue;
            }
            if (comparator.compare(node.value, value) > 0) {
                return false;
            }
            node = next.down;
        }
        return false;
    }
}
