package Entity;

import java.util.*;
import java.util.stream.Collector;

/**
 * prefix tree
 * @author ZAXIE
 * @date 2023/10/4 14:24
 */
public class TriTree {
    Node root;

    private class Node {
        int pass;
        int end;
        Map map;

        public Node() {
            pass = 0;
            end = 0;
            map = new HashMap<Character, Node>();
        }
    }

    public TriTree() {
        root = new Node();
    }

    public void insert(String str) {
        char[] chars = str.toCharArray();
        Node node = root;
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            Node temp = (Node) node.map.get(chars[i]);
            if (temp == null) {
                temp = new Node();
                node.map.put(chars[i], temp);
            }
            node = temp;
            node.pass++;
        }
        node.end++;
    }

    public Integer findPrefixNumber(String string) {
        Node node = findNode(string);
        return node == null ? 0 : node.pass;
    }

    public Integer findFullStringNumber(String string) {
        Node node = findNode(string);
        return node == null ? 0 : node.end;
    }

    public void delete(String str) {
        if (findFullStringNumber(str) != 0) {
            Node node = root;
            node.pass--;
            for (int i = 0; i < str.length(); i++) {
                Node temp = (Node) node.map.get(str.charAt(i));
                if (--temp.pass == 0) {
                    node.map.remove(str.charAt(i));
                    return;
                }
                node = temp;
            }
            node.end--;
        } else {
            System.err.println(str + "has not inserted in to this tree");
        }
    }

    public void displayAllElem() {
        Map<String, Integer> map = new HashMap();
        // use dfs to view this tree
        dfs("", root, map);
        System.out.println(map);
        return;
    }

    private void dfs(String s, Node node, Map<String, Integer> map) {
        if (node.end != 0) {
            map.put(s, map.get(s) == null ? node.end : map.get(s) + node.end);
        }
        Set<Character> set = node.map.keySet();
        for (Character c : set) {
            String string = s + c;
            dfs(string, (Node) node.map.get(c), map);
        }
    }

    private Node findNode(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            node = (Node) node.map.get(string.charAt(i));
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
