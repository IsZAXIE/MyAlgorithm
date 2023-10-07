package Test.entity;

import AOPTest.TestRuntime.MyAOPTest;
import Entity.AOPInterface.MyRunAOPInterface;
import Entity.TriTree;

/**
 * @author ZAXIE
 * @date 2023/10/4 17:38
 */
public class TestTriTree implements MyRunAOPInterface {

    TriTree tree = new TriTree();


    public static void main(String[] args) {
        MyAOPTest.testRunTime(TestTriTree.class);
    }
    public void insert(){
        tree.insert("hi");
        tree.insert("hello");
        tree.insert("is");
        tree.insert("somebody");
        tree.insert("here");
        tree.insert("hi");
        tree.insert("ok");
        tree.displayAllElem();
    }

    public void findPrefix(){
        System.out.println();
        System.out.println("prefix hi   : "+tree.findPrefixNumber("h"));
        System.out.println("prefix he   : "+tree.findPrefixNumber("he"));
        System.out.println("prefix hi   : "+tree.findPrefixNumber("hi"));
        System.out.println("prefix hihi : "+tree.findPrefixNumber("hihi"));
    }

    public void findFullString(){
        System.out.println();
        System.out.println("fullString hi   : "+tree.findFullStringNumber("hi"));
        System.out.println("fullString here : "+tree.findFullStringNumber("here"));
        System.out.println("fullString her  : "+tree.findFullStringNumber("her"));
    }

    public void delete(){
        System.out.println("\n\n\n");
        tree.delete("hi");
        tree.delete("here");
        tree.displayAllElem();
    }
}
