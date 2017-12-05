package salary;

import implement.classification.CommissionedClassification;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.entity.SalesReceipt;
import implement.transaction.AddCommissionedEmployee;
import implement.transaction.AddSalesReceiptTransaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * 销售记录测试
 * 销售记录只有带薪人员才有
 * Created by ZD on 2017/10/24.
 */
public class SalesReceiptTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testSalesReceiptTransaction(){

        long id = 6;
        String name = "Bob6";
        String address = "Bob6.home";
        double monthlyPay = 1000;
        double commissionRate = 5;

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(id,name,address,monthlyPay,commissionRate);
        addCommissionedEmployee.execute();

        Date date =  new Date(2017,10,24);
        int amount = 3;

        AddSalesReceiptTransaction salesReceiptTransaction = new AddSalesReceiptTransaction(date,3,id);
        salesReceiptTransaction.execute();

        Employee e = payrollDatabase.getEmployeeById(id);

        CommissionedClassification commissionedClassification = (CommissionedClassification) e.getPaymentClassification();

        SalesReceipt salesReceipt = commissionedClassification.getSalesReceipt(date);


        assertEquals(salesReceipt.getAmount(),3);

    }

}
