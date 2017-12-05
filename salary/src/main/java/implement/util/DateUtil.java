package implement.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 日期类
 * Created by ZD on 2017/10/26.
 */
public class DateUtil {

    private  static  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static boolean IsInPayPeriod(Date date, Date payPeriodStartDate, Date payPeriodEndDate) {
        return (date.after(payPeriodStartDate)) && (date.before(payPeriodEndDate));
    }

    /**
     * 是否为月末
     * @param date
     * @return
     */
    public static boolean isMonthDay(Date date){
        if (date == null)
            return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        Date date1 = calendar.getTime();
        if (date.compareTo(date1) == 0)
            return true;
        return false;
    }

    /**
     * 是否为周五
     * @param date
     * @return
     */
    public static boolean isWeekDay(Date date){
        if (date == null)
            return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 6)
            return true;
        return false;
    }


    /**
     * 获取当前日期
     * @return
     */
    public static Date getDate(){
        return DateUtil.getDateFormat(dateFormat.format(new Date()));
    }

    /**
     * 获取日期格式化
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
