package implement.transaction;

import implement.database.PayrollDatabase;

/**
 * Created by ZD on 2017/10/24.
 */
public class DeleteEmployeeTransaction implements Transaction {

    private long id;

    public DeleteEmployeeTransaction(){}

    public DeleteEmployeeTransaction(long id){
        this.id = id;
    }

    public void execute() {
        PayrollDatabase.getPayrollDatabase().deleteEmployeeById(id);
    }
}
