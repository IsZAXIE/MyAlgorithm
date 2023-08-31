package Utils;

/**
 * @author ZAXIE
 * @date 2023/8/31 08:17
 */
public class ColorPrintUtils {
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";


    public static void printRed(Object o){
        System.out.print(RED+o+RESET);
    }
    public static void printGreen(Object o){
        System.out.print(GREEN+o+RESET);
    }
    public static void printCyan(Object o){
        System.out.print(CYAN+o+RESET);
    }
}
