package Test.base;

/**
 * @author ZAXIE
 * @date 2023/9/20 17:26
 */
public class TestInteger {
    public static void main(String[] args) {

        System.out.println("(0-1)/2 = " + (0 - 1) / 2);
        StringClass stringClass = new StringClass();
        stringClass.setStr(1);
        System.out.println(stringClass.getStr());

        stringClass.setStr(10);
        System.out.println(stringClass.getStr());

        stringClass.setStr(1);
        System.out.println(stringClass.getStr());

        stringClass.setStr(1);
        System.out.println(stringClass.getStr());

        stringClass.setStr(1);
        System.out.println(stringClass.getStr());


    }
}

class StringClass {
    String str;

    public Integer getStr() {
        return Integer.valueOf(str);
    }

    public void setStr(Integer str) {
        this.str = "" + str;
    }
}