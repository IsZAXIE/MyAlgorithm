package Test.base;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;

/**
 * @author ZAXIE
 * @date 2023/11/1 16:59
 */
public class BigDecimalStringTest {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(100.250000000);
        DecimalFormat format = new DecimalFormat(".00");

        System.out.println(bigDecimal);
        System.out.println(format.format(bigDecimal));
    }

}
