package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateWork {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY MMM d HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
