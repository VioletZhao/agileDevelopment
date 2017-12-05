package implement.transaction;

import implement.classification.HourlyClassification;
import implement.classification.PaymentClassification;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.entity.TimeCard;

import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class AddTimecardTransaction implements Transaction {

    private Date date;
    private double hours;
    private long empId;

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    public AddTimecardTransaction(){}

    public AddTimecardTransaction(Date date, double hours, long empId){
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    public void execute(){
        Employee e = payrollDatabase.getEmployeeById(empId);

        HourlyClassification hourlyClassification = (HourlyClassification) e.getPaymentClassification();
        TimeCard timeCard = new TimeCard(date,hours);
        hourlyClassification.addTimeCard(timeCard);


    }


    public double getHours() {
        return hours;
    }
}
