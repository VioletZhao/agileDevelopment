package salary;

import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.transaction.AddSalariedEmployee;
import implement.transaction.DeleteEmployeeTransaction;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * 删除雇员
 * Created by ZD on 2017/10/24.
 */
public class DeleteEmployeeTransactionTest {


    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testDeleteEmployee(){
        long id = 4;
        String name = "Bob4";
        String address = "Bob4.home";
        double monthlyPay = 1000;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(id,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(id);
        //assertEquals(e,addSalariedEmployee);

        DeleteEmployeeTransaction deleteEmployeeTransaction = new DeleteEmployeeTransaction(id);
        deleteEmployeeTransaction.execute();

        assertNull(payrollDatabase.getEmployeeById(id));


    }


}
