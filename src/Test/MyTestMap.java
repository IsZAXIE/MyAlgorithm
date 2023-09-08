package Test;

import Util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class MyTestMap {
    public static void main(String[] args) {
        int[] a = ArrayUtils.initArray(20);
        Map<Integer, Integer> map = new HashMap<>();
        ArrayUtils.printArray(a, "Original Arrays");

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }

        System.out.println("keySet : " + map.keySet());
        System.out.printf(String.valueOf(map.values().getClass()));
        System.out.println();
        System.out.println("\tvalues : " + map.values());

        for (int i = 0; i < a.length * 1.5; i++) {
            if (map.get(i) != null) {
                System.out.println(i + " : " + map.get(i));
            }
        }

        System.out.println(map);
    }
}

class MyVector {

}

