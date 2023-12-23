package MyTree;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Entity.TreeNode;
import Util.TreeNodeUtils;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author ZAXIE
 * @date 2023/11/5 18:48
 */
public class Traverse implements MyRunAOPInterface {
    public static void main(String[] args) {
        MyAOPTest.testRunTime(Traverse.class);
    }

    public void preOrder() {
        TreeNode<Integer> root = TreeNodeUtils.initTree(new Integer[]{0, 1, 8, 2, 5, 9, 10, 3, 4, 6, 7});
        System.out.println("recursion preOrder: ");
        recursionPreOrder(root);
        System.out.println("\nnon-recursion preOrder: ");
        nonRecursionPreOrder(root);
    }

    public void inOrder() {
        TreeNode<Integer> root = TreeNodeUtils.initTree(new Integer[]{0, 1, 8, 2, 5, 9, 10, 3, 4, 6, 7});
        System.out.println("recursion inOrder: ");
        recursionInOrder(root);
        System.out.println("\nnon-recursion inOrder: ");
        nonRecursionInOrder(root);
    }

    public void postOrder() {
        TreeNode<Integer> root = TreeNodeUtils.initTree(new Integer[]{0, 1, 8, 2, 5, 9, 10, 3, 4, 6, 7});
        System.out.println("recursion postOrder: ");
        recursionPostOrder(root);
        System.out.println("\nnon-recursion postOrder: ");
        nonRecursionPostOrderTwoStack(root);
        System.out.println("\nnon-recursionOneStack postOrder: ");
        nonRecursionPostOrderOneStack(root);
        System.out.println("\nnon-recursionOneStackFromZuo postOrder: ");
        nonRecursionPostOrderOneStackZuo(root);
    }


    private <T> void recursionPreOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        recursionPreOrder(root.left);
        recursionPreOrder(root.right);
    }

    private <T> void nonRecursionPreOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<T>> help = new Stack<>();
        help.push(root);
        while (!help.isEmpty()) {
            TreeNode<T> node = help.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                help.push(node.right);
            }
            if (node.left != null) {
                help.push(node.left);
            }
        }
        System.out.println();
    }

    private <T> void recursionInOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        recursionInOrder(root.left);
        System.out.print(root.value + " ");
        recursionInOrder(root.right);
    }

    private <T> void nonRecursionInOrder(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> head = root;

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // handle left
                // push all leftChild
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                // handle middle element
                System.out.print(head.value + " ");
                // handle right
                head = head.right;
            }
        }
        System.out.println();
    }

    private <T> void recursionPostOrder(TreeNode<T> root) {
        if (root != null) {
            recursionPostOrder(root.left);
            recursionPostOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * convert into {right, left, head} and then, reverse
     *
     * @param root root of the tree
     * @param <T>  type
     */
    private <T> void nonRecursionPostOrderTwoStack(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        Stack<T> valueStack = new Stack<>();
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode<T> node = nodeStack.pop();
            valueStack.push(node.value);
            if (node.left != null) {
                nodeStack.push(node.left);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
            }
        }
        while (!valueStack.isEmpty()) {
            System.out.print(valueStack.pop() + " ");
        }
    }

    private <T> void nonRecursionPostOrderOneStack(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> left = root;
        TreeNode<T> right;
        while (left != null || !stack.isEmpty()) {
            if (left != null) {
                // handle left
                stack.push(left);
                left = left.left;
            } else {
                right = stack.peek().right;
                if (right != null) {
                    // push not-null element
                    stack.push(right);
                    // handle left
                    left = right.left;
                } else {
                    // right == null : handle middle element
                    while (true) {
                        TreeNode<T> head = stack.pop();
                        System.out.print(head.value + " ");
                        left = head;
                        right = head;
                        if (right == root) {
                            System.out.println();
                            return;
                        }
                        // judge left handled or right handled
                        head = stack.peek();
                        if (head.left == left) {
                            left = null;
                            break;
                        }
                        // head right has been handled: pop() its parent node
                    }
                }
            }
        }
    }

    /**
     * all idea are from ZuoChengyun
     *
     * @param root
     * @param <T>
     */
    private <T> void nonRecursionPostOrderOneStackZuo(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        if (root == null) {
            return;
        } else {
            stack.push(root);
        }

        // currant node pointer
        TreeNode<T> c = root;
        // last print node pointer
        TreeNode<T> l = root;

        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != l && c.right != l && c.left != null) {
                // left child hasn't been visited and it not equals null
                stack.push(c.left);
            } else if (l != c.right && c.right != null) {
                // if program can run here means leftChild han been handled,
                // we just need to judge if rightChild are visited
                // if thisNode.right != null means its right node need to be handled
                stack.push(c.right);
            } else {
                // left and right are null or has been handled
                System.out.print(stack.pop().value + " ");
                l = c;
            }
        }
        System.out.println();
    }

}
