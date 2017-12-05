package implement.transaction;

import implement.classification.PaymentClassification;

import implement.entity.Employee;
import implement.schedule.PaymentSchedule;

/**
 * 更改类别
 * Created by ZD on 2017/10/25.
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(){}

    public ChangeClassificationTransaction(int empId){
        super(empId);
    }

    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());

    }

    protected abstract PaymentSchedule getSchedule();

    protected abstract PaymentClassification getClassification();


}
