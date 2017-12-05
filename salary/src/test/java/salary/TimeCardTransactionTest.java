package salary;

import implement.classification.HourlyClassification;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.entity.TimeCard;
import implement.transaction.AddHourlyEmployee;
import implement.transaction.AddTimecardTransaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * 时间卡测试
 * Created by ZD on 2017/10/24.
 */
public class TimeCardTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void addTimeCardTest(){
        int empId = 5;
        String name = "Bob5";
        String address = "Bob5.home";
        double hourlyPay = 20;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Date date = new Date(2017,10,24);

        AddTimecardTransaction timecardTransaction = new AddTimecardTransaction(date,8.0,empId);
        timecardTransaction.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);

        HourlyClassification paymentClassification = (HourlyClassification) e.getPaymentClassification();

        TimeCard timeCard = paymentClassification.getTimeCard(date);
      System.out.println(((HourlyClassification) e.getPaymentClassification()).getTimeCard(date).getHours());


    }
}
