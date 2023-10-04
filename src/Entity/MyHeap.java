package Entity;

import Util.ArrayUtils;

import java.util.*;

/**
 * @author ZAXIE
 * @date 2023/9/30 15:27
 */

/**
 * class of T must be comparable
 *
 * @param <T>
 */
public class MyHeap<T> {
    List<T> heap;

    /**
     * this map is used to record relationship between T object and index of list
     * so that when you need to resign the heap, you can get the relationship easily.
     */
    Map<T, Integer> indexMap = new HashMap();

    Comparator<T> comparator;


    public MyHeap(Comparator <? extends T> comparator) {
        heap = new ArrayList<>();
        this.comparator = (Comparator<T>) comparator;

    }

    public void setHeap(List<? extends T> list) {
        heap = (List<T>) list;
    }

    public List<T> initHeap(int length) {
        // TODO
        return heap;
    }


    public void heapify() {
        // TODO

    }
}
