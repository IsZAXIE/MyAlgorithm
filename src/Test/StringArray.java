package Test;

import Sort.ArrayUtils;

import java.util.Arrays;

public class StringArray {
    public static void main(String[] args) {
        String str="1a2a3a4a5a6a7";
        System.out.println(str);
        String[] strList = str.split("a");
        strList[1]="3";
        System.out.print(Arrays.toString(strList));
    }
}
