package implement.schedule;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class BiweeklySchedule implements PaymentSchedule {

    public boolean isPayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && calendar.get(Calendar.WEEK_OF_MONTH)%2 == 0;
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-13);
        return calendar.getTime();
    }
}
