package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {
            String dateString = format.format(date);
            date = format.parse(dateString);
            System.out.println("dateString : "+dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date : " + date);

    }
}
