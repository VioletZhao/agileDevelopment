package implement.schedule;

import implement.util.DateUtil;
import sun.util.resources.CalendarData_ar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class WeeklySchedule implements PaymentSchedule {


    public boolean isPayDate(Date date) {
        return DateUtil.isWeekDay(date);
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-6);
        return calendar.getTime();
    }
}
