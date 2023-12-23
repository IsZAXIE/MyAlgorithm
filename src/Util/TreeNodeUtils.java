package Util;

import Entity.TreeNode;

/**
 * @author ZAXIE
 * @date 2023/11/12 13:12
 */
public class TreeNodeUtils {
    public static <T> TreeNode<T> initTree(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode<T> root = new TreeNode<>(arr[0]);
        // index of leftChild is 2i+1
        // index of rightChild is 2i+2
        root.left = initChild(1, arr);
        root.right = initChild(2, arr);
        return root;
    }

    private static <T> TreeNode<T> initChild(int i, T[] arr) {
        if (i >= arr.length) {
            return null;
        }
        TreeNode<T> thisNode = new TreeNode<>(arr[i]);
        thisNode.left = initChild((2 * i + 1), arr);
        thisNode.right = initChild((2 * i + 2), arr);
        return thisNode;
    }
}
