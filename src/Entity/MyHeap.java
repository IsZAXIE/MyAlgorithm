package Entity;

import Util.ArrayUtils;
import Util.ColorPrintUtils;

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

    public MyHeap(Comparator<? extends T> comparator) {
        heap = new ArrayList<>();
        this.comparator = (Comparator<T>) comparator;

    }

    public void setHeap(List<? extends T> list) {
        heap = (List<T>) list;
    }

    public void initHeap() {
        heap = new ArrayList<>();
    }

    public void initHeap(List<T> list, boolean deepCopy) {
        if (deepCopy) {
            heap.addAll(list);
        } else {
            heap = list;
        }
        for (int i = (heap.size() - 2) / 2; i >= 0; i--) {
            heapify(i);
        }
        /*
        // or use heapInsert() to generate heap (slower than heapify)
        for (int i = 0; i < heap.size(); i++) {
            heapInsert(i);
        }
        */
    }

    /**
     * generate small root heap
     *
     * @param index
     * @param size
     */
    public void heapify(int index, int size) {
        int lc = index * 2 + 1;
        while (lc < size) {
            int rc = lc + 1;
            int maxIndex = rc >= size ? lc : comparator.compare(heap.get(lc), heap.get(rc)) < 0 ? lc : rc;
            if (comparator.compare(heap.get(index), heap.get(maxIndex)) > 0) {
                swap(index, maxIndex);
            }
            index = maxIndex;
            lc = index * 2 + 1;
        }
    }

    public void heapify(int index) {
        heapify(index, heap.size());
    }


    public void heapInsert(int index, int size) {
        while (index != 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap.get(parentIndex), heap.get(index)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }

    }

    public void heapInsert(int index) {
        heapInsert(index, heap.size());
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void check() {
        for (int i = 0; i <= (heap.size() - 2) / 2; i++) {
            int lc = i * 2 + 1;
            int rc = lc + 1;
            if (comparator.compare(heap.get(i), heap.get(lc)) > 0 || (rc < heap.size() && comparator.compare(heap.get(i), heap.get(rc)) > 0)) {
                ColorPrintUtils.printRed("\nerror : " + heap.get(i) + " > " + heap.get(lc));
                if (rc < heap.size()) {
                    ColorPrintUtils.printRed(" or " + heap.get(rc) + "\n");
                }
                return;
            }
        }
        ColorPrintUtils.printGreen("heapCheck : pass\t");
        System.out.println(heap);
    }
}
