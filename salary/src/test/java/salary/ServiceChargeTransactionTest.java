package salary;

import implement.affiliation.UnionAffiliation;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.entity.ServiceCharge;
import implement.transaction.AddHourlyEmployee;
import implement.transaction.AddServiceChargeTransaction;
import org.junit.Test;

import java.util.Date;

/**
 * 会费扣除测试
 * Created by ZD on 2017/10/24.
 */
public class ServiceChargeTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testAddServiceChargeTransaction(){
         int empId = 7;
         String name = "Bob7";
         String address = "Bob7.home";
         double hourlyPay = 25;

         int memberId = 1;
         double amount = 12.5;
         Date date = new Date();

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);

        UnionAffiliation af = new UnionAffiliation(memberId,amount);
        e.setAffiliation(af);



        payrollDatabase.addUnionMember(memberId,e);
        AddServiceChargeTransaction serviceChargeTransaction = new AddServiceChargeTransaction(memberId,date,amount);
        serviceChargeTransaction.execute();

        ServiceCharge serviceCharge = af.getServiceCharge(date);
        System.out.println(serviceCharge.getAmount());

    }

}
