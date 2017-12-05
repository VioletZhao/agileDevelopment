package implement.schedule;

import implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * 月末支付员工薪水
 * Created by ZD on 2017/10/24.
 */
public class MonthlySchedule implements PaymentSchedule {

    /*
    判断是否为月末
     */
    public boolean isPayDate(Date date) {
        return DateUtil.isMonthDay(date);
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONTH) == month){
            calendar.add(Calendar.DATE,-1);
        }
        return calendar.getTime();
    }
}
