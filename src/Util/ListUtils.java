package Util;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/9/12 16:32
 */
public class ListUtils {

    public static final <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println();
    }

    public static final <T extends File> void printlnFileList(List<T> list) {
        System.out.println("size = "+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
