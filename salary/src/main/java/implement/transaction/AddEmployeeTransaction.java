package implement.transaction;

import implement.classification.PaymentClassification;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.method.HoldMethod;
import implement.method.PaymentMethod;
import implement.schedule.PaymentSchedule;

/**
 *采用模板模式实现
 * Created by ZD on 2017/10/24.
 */
public abstract class AddEmployeeTransaction implements Transaction {

    private long id;
    private String name;
    private String address;

    public AddEmployeeTransaction(){}

    public AddEmployeeTransaction(long empid,String name,String address){
        this.id = empid;
        this.name = name;
        this.address = address;
    }

    public void execute(){
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchdule();
        PaymentMethod pm = getMethod();
        Employee e = new Employee(id,name,address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);


        PayrollDatabase.getPayrollDatabase().addEmployee((int) id,e);

    }

    protected PaymentMethod getMethod(){
        return new HoldMethod();
    }

    protected abstract PaymentSchedule getSchdule();

    protected abstract PaymentClassification getClassification();

}
