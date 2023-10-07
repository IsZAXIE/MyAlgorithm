package Entity;

public class SingleNode<T> {


    public T value;

    public SingleNode next;

    public SingleNode() {
    }

    public SingleNode(T value) {
        this.value = value;
    }

    public SingleNode(T value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    public void append(T value) {
        SingleNode sn = this;
        while (sn.next != null) {
            sn = sn.next;
        }
        sn.next = new SingleNode(value);
    }

    public SingleNode leftAppend(T value) {
        SingleNode sn = new SingleNode(value);
        sn.next = this;
        return sn;
    }

    public void print() {
        SingleNode head = this;
        while (head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public void append(T[] arr) {
        if (arr.length == 0) {
            return;
        }
        SingleNode root = new SingleNode(arr[0]);
        SingleNode temp = root;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new SingleNode(arr[i]);
            temp = temp.next;
        }
        temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = root;
    }
}