package implement.transaction;

import implement.database.PayrollDatabase;
import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/24.
 */
public abstract class ChangeEmployeeTransaction implements Transaction {

    private long empID;

    public ChangeEmployeeTransaction(int empID) {
        this.empID = empID;
    }

    public ChangeEmployeeTransaction(){}

    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployeeById(empID);
        if (e != null){
            change(e);
        }
    }

    public abstract void change(Employee e);
}
