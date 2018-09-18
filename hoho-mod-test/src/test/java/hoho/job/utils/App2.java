package hoho.job.utils;

import java.util.Date;

public class App2 {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1.toString());

        Date date2 = new Date();

        Character c = new Character('b');

        Runtime time = Runtime.getRuntime();
        System.out.println(time.freeMemory());
    }
}
