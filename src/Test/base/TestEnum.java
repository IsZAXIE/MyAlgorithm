package Test.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZAXIE
 * @date 2023/9/1 08:02
 */
public enum TestEnum {
    ENUM_ONE(0, "AA"),
    ENUM_TWO(1, "BB"),
    ENUM_THREE(2, "CC"),
    ENUM_FOUR(3, "DD"),
    ENUM_FIVE(4, "EE"),
    ENUM_SIX(5, "FF"),
    ENUM_SEVEN(6, "GG"),
    ENUM_EIGHT(7, "HH"),
    ENUM_NINE(8, "II"),
    ENUM_TEN(9, "JJ");

    TestEnum(Integer i, String value) {
        this.index = i;
        this.value = value;
    }

    private Integer index;
    private String value;

    public String getValue() {
        return value;
    }

    public Integer getIndex() {
        return index;
    }

    public static String getValue(String name) {
        TestEnum testEnum = TestEnum.valueOf(name);
        return testEnum.getValue();
    }


    public static String getValue(Integer index) {
        // we can use '==' because of index lt(<) 128 and ge( >= ) -128
        for (TestEnum tmp : TestEnum.values()) {
            if (index.equals(tmp.index)) {
                return tmp.getValue();
            }
        }
        return null;
    }

    public static String getStreamValue(Integer index) {
        List<TestEnum> list = new ArrayList<>();
        Stream.of(TestEnum.values()).filter(v -> v.getIndex().equals(index)).forEach(d -> list.add(d));

//        return list.get(0).getValue();

//        try {
            return list.get(0).getValue();
        /*} catch (Exception e) {
            throw e;
        }*/
    }

}

class EnumMain {
    public static void main(String[] args) {
        TestEnum test = TestEnum.ENUM_ONE;
        String name = "ENUM_ONE";
        System.out.println(TestEnum.getValue(name));
        System.out.println(test);
        System.out.println(test.getValue());
        System.out.println(TestEnum.getValue(7));
        System.out.println(TestEnum.getValue(100));
        if (TestEnum.getValue(100) == null) {
            System.out.println("TestEnum.getValue(100) == null");
        }
        System.out.println("TestEnum.getStreamValue(3) = " + TestEnum.getStreamValue(3));
        try {
            System.out.println("TestEnum.getStreamValue(100) = " + TestEnum.getStreamValue(100));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException; " + "TestEnum.getStreamValue(100) = " + null);
        }

        /*
        System.out.println("\"a\".equals(null) : " + "a".equals(null));
        */

        /*
        Integer MyNull=null;
        System.out.println("\"a\".equals(null) : " + MyNull.equals(null));
        */
    }
}
