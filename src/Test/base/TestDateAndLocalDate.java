package Test.base;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @author ZAXIE
 * @date 2023/11/3 15:34
 */
public class TestDateAndLocalDate {
    public static void main(String[] args) {
        dateToLocalDate();
        System.out.println();
        localDateToDate();
    }

    private static void dateToLocalDate() {
        // 获取当前日期
        Date date = new Date();

        // 将Date转换为LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String s = LocalDate.now().toString();
        localDate = LocalDate.parse(s);
        System.out.println("parse: " + localDate);
        System.out.println("s = " + s);
        System.out.println("LocalDate: " + localDate);
        int subWeek = 1;
        localDate = localDate.minusWeeks(-subWeek);

        System.out.println("Date: " + date);
        System.out.println("NextWeek: " + localDate);
    }

    private static void localDateToDate() {
        // 获取当前日期
        LocalDate localDate = LocalDate.now();

        // 将LocalDate转换为Date
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("LocalDate: " + localDate);
        System.out.println("Date: " + date);
    }

}
