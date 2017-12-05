package salary;

import implement.payday.PayCheck;
import implement.transaction.AddHourlyEmployee;
import implement.transaction.AddSalariedEmployee;
import implement.transaction.AddTimecardTransaction;
import implement.transaction.PayDayTransaction;
import implement.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.internal.QueryImpl;
import org.hibernate.internal.SQLQueryImpl;
import org.junit.Test;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 支付雇员薪水测试
 * Created by ZD on 2017/10/26.
 */
public class PayrollTest {

    /**
     * 支付正常员工薪资
     */
    @Test
    public void testPaySalariedEmployee(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 6000;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Date payDate = DateUtil.getDateFormat("2017-11-30");
        PayDayTransaction payDayTransaction = new PayDayTransaction(payDate);
        payDayTransaction.execute();

        PayCheck payCheck = payDayTransaction.getPayCheck(empId);
        assertEquals(payDate, payCheck.getPayDate());
    }


    @Test
    public void testPaySalariedEmployeeOnWrongDate(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 6000;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Date payDate = DateUtil.getDateFormat("2017-11-26");

        PayDayTransaction payDayTransaction = new PayDayTransaction(payDate);
        payDayTransaction.execute();

        PayCheck payCheck = payDayTransaction.getPayCheck(empId);
        assertEquals(null,payCheck);

    }

    /**
     * 支付钟点工薪水
     */
    @Test
    public void testPayHourlyEmployee(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Date payDate = DateUtil.getDateFormat("2017-11-24");

        PayDayTransaction payDayTransaction = new PayDayTransaction(payDate);
        payDayTransaction.execute();

        validatePayCheck(payDayTransaction,empId,payDate,0.0);

    }

    private void validatePayCheck(PayDayTransaction payDayTransaction, int empId, Date payDate, double v) {
        PayCheck payCheck = payDayTransaction.getPayCheck(empId);
        assertEquals(payCheck.getPayDate(),payDate);
    }

    @Test
    public void testPayHourlyEmployeeOnWrongDate(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Date payDate = DateUtil.getDateFormat("2017-11-28");

        PayDayTransaction payDayTransaction = new PayDayTransaction(payDate);
        payDayTransaction.execute();

        PayCheck payCheck = payDayTransaction.getPayCheck(empId);
        assertNotEquals(null,payDate);
    }


    /**
     * 支付具有单一时间卡的雇员薪水
     */
    @Test
    public void testPaySingleHourlyEmployee(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Date payDate = new Date(2017,10,28);

        AddTimecardTransaction addTimecardTransaction = new AddTimecardTransaction(payDate,2.0,empId);
        addTimecardTransaction.execute();

        PayDayTransaction payDayTransaction = new PayDayTransaction(payDate);
        payDayTransaction.execute();
    }

    @Test
    public void testPayCommissionEmployee(){}

    @Test
    public void testPayCommissionEmployeeOnWrongDate(){}

}
