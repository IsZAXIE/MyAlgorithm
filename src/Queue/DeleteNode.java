package Queue;

import Entity.SingleNode;
import Utils.NodeUtils;

/**
 * @author ZAXIE
 * @date 2023/8/27 16:54
 */
public class DeleteNode {
    private static final int NODE_LIST_LENGTH = 20;

    public static void main(String[] args) {
        SingleNode singleHead = NodeUtils.initRandomSingleNode(NODE_LIST_LENGTH,NODE_LIST_LENGTH);

        if(singleHead==null){
            System.err.println("SingleHead == null");
            return;
        }

        NodeUtils.printSingleNode(singleHead,"Origin nodeList : ");
        int deleteSingleValue=singleHead.value;
        // need return because the head of nodeList may be deleted and the argument may point to null
        singleHead = deleteSingleNodeElems(singleHead,singleHead.value);
        NodeUtils.printSingleNode(singleHead,"After Delete "+deleteSingleValue+" : ");
    }

    private static SingleNode deleteSingleNodeElems(SingleNode head, int value) {
        SingleNode temp=head;
        SingleNode pre=head;
        while (temp!=null){
            if(temp.value==value){
                if(head==temp){
                    // change head node
                    head=head.next;
                    temp=head;
                }
                else {
                    // delete this elem
                    pre.next=temp.next;
                    temp=temp.next;
                }
            }
            else {
                pre=temp;
                temp= temp.next;
            }
        }
        return head;
    }

}
