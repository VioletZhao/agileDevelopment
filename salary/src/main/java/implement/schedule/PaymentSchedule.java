package implement.schedule;

import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public interface PaymentSchedule {
    boolean isPayDate(Date date);

    Date getPayPeriodStartDate(Date date);
}
