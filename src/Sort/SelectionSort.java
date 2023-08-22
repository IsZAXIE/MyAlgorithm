package Sort;

public class SelectionSort {
    static int times = 0;

    public static void main(String[] args) {
        int[] a = ArrayUtils.initArray(20);
        ArrayUtils.printArray(a, "初始化数组 : ");

        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int maxIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    times++;
                    min = a[j];
                    maxIndex = j;
                }
            }
            ArrayUtils.swap(a, maxIndex, i);
        }

        ArrayUtils.printArray(a, "排序后数组 : ", times);

    }
}
