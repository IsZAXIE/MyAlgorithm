package Test;

import Util.ListUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZAXIE
 * @date 2023/9/12 16:18
 */
public class FileTest {
    static List<File> files;

    public static void main(String[] args) {
        File root = new File("/Users/zaxie/MyProgram");
        files = new LinkedList<>();
        getFile(root);
        ListUtils.printlnFileList(files);
    }

    private static void getFile(File root) {
        if (root == null) {
            return;
        }
        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                getFile(file);
            }
        } else {
            files.add(root);
        }
    }
}
