package implement.transaction;

import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.payday.PayCheck;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by ZD on 2017/10/26.
 */
public class PayDayTransaction implements Transaction {

    private Date date;
    private Hashtable<Integer,PayCheck> paychecks = new Hashtable<Integer, PayCheck>();

    public PayDayTransaction(){}

    public PayDayTransaction(Date date){
        this.date = date;
    }

    public void execute() {
        List<Employee> employees = PayrollDatabase.getPayrollDatabase().getAllEmployees();
        for (Employee e : employees){
            if (e != null){
                if (e.isPayDate(date)){
                    Date startDate = e.getPayPeriodSatrtDate(date);
                    PayCheck payCheck = new PayCheck(startDate,date);
                    paychecks.put(e.getEmpId(),payCheck);
                    e.payDay(payCheck);
                }
            }
        }
    }

    public PayCheck getPayCheck(int empId){
        return paychecks.get(empId);
    }
}
