package salary;

import implement.affiliation.NoAffiliation;
import implement.affiliation.UnionAffiliation;
import implement.classification.CommissionedClassification;
import implement.classification.HourlyClassification;
import implement.classification.SalariedClassification;
import implement.database.PayrollDatabase;
import implement.entity.Employee;
import implement.method.DirectMethod;
import implement.method.HoldMethod;
import implement.method.PaymentMethod;
import implement.transaction.*;
import org.junit.Test;
import sun.org.mozilla.javascript.internal.regexp.SubString;

import static org.junit.Assert.*;

/**
 * 更改雇员属性测试
 * Created by ZD on 2017/10/24.
 */
public class ChangeEmployeeTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    /**
     * 改变员工名称
     */
    @Test
    public void testChangeNameTransaction(){

        int empID = 1;
        String name = "Bob1";
        String address = "Bob1.home";
        double monthlyPay = 2000;

        String newName = "Bob";

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empID,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empID);

        ChangeNameTransaction changeNameTransaction = new ChangeNameTransaction(empID,newName);
        changeNameTransaction.execute();


        assertEquals(newName,e.getName());
    }

    /**
     * 改变员工地址
     */
    @Test
    public void testChangeAddressTransaction(){
        int empId = 2;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay =  2000;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);
        String newAddress = "Bob.address";

        ChangeEmployeeTransaction changeAddressTransaction = new ChangeAddressTransaction(empId,newAddress);
        changeAddressTransaction.execute();

        assertEquals(e.getAddress(),newAddress);
    }

    /**
     * 改变员工属性-->转为小时工
     */
    @Test
    public void testChangeHourlyClassificationTransaction(){
        int empId = 3;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPsay = 3000;
        double commissionRate = 5;

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(empId,name,address,monthlyPsay,commissionRate);
        addCommissionedEmployee.execute();

        double hourlyPay = 15;
        ChangeEmployeeTransaction changeHourlyTransaction  = new ChangeHourlyTransaction(empId,hourlyPay);
        changeHourlyTransaction.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);
        HourlyClassification hourlyClassification = (HourlyClassification) e.getPaymentClassification();

        assertEquals(e.getPaymentClassification(),hourlyClassification);

    }

    /**
     * 改变员工属性-->转为正常员工
     */
    @Test
    public void changeSalariedTransaction(){
        int empID = 4;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 30;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empID,name,address,hourlyPay);
        addHourlyEmployee.execute();

        double monthlyPay = 3000;
        ChangeSalariedTransaction changeSalariedTransaction = new ChangeSalariedTransaction(empID,monthlyPay);
        changeSalariedTransaction.execute();

        Employee e = payrollDatabase.getEmployeeById(empID);
        SalariedClassification classification = (SalariedClassification) e.getPaymentClassification();

    }

    /**
     * 改变员工属性-->转为带薪员工
     */
    @Test
    public void changeCommissionedTransaction(){
        int empId = 5;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 3300;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        double monthlyBase = 3000;
        double commissionRate = 5;

        ChangeMissionedClassification changeMissionedClassification = new ChangeMissionedClassification(empId,monthlyBase,commissionRate);
        changeMissionedClassification.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);
        CommissionedClassification commissionedClassification = (CommissionedClassification) e.getPaymentClassification();
    }

    /**
     * 改变支付方式-->直接存款
     */
    @Test
    public void testChangeDirectTransaction(){
        int id = 1;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 4000;

        HoldMethod holdMethod = new HoldMethod();

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(id,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(id);
        e.setPaymentMethod(holdMethod);

        String bank = "bank";
        double acount = 4000;

        ChangeDirectTransaction changeDirectTransaction = new ChangeDirectTransaction(id,bank,acount);
        changeDirectTransaction.execute();

        assertNotEquals(e.getPaymentMethod(),holdMethod);


    }

    /**
     * 改变支付方式-->持有支票
     */
    @Test
    public void testChangeHoldMethod(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);

        String bank = "bank";
        double accout = 3000;

        DirectMethod directMethod = new DirectMethod(bank,accout);
        e.setPaymentMethod(directMethod);

        ChangeHoldMethodTransaction changeHoldMethodTransaction = new ChangeHoldMethodTransaction(empId);
        changeHoldMethodTransaction.execute();
    }

    /**
     * 改变支付方式-->邮寄
     */
    @Test
    public void testChangeMailMethod(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 3000;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        String mailAddress = "BobMail.home";
        Employee e = payrollDatabase.getEmployeeById(empId);

        ChangeMailMethodTransaction changeMailMethodTransaction = new ChangeMailMethodTransaction(empId,mailAddress);
        changeMailMethodTransaction.execute();
        System.out.println(e.getPaymentMethod());

    }

    /**
     * 改变员工属性-->加入协会
     */
    @Test
    public void testChangeMemberTransaction(){
       int empId = 1;
       String name = "Bob";
       String address = "Bob.home";
       double monthlyPay = 3000;

       AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
       addSalariedEmployee.execute();

       int memberId = 20;
       ChangeEmployeeTransaction changeMemberTransaction = new ChangeMemberTransaction(empId,memberId,99.42);
       changeMemberTransaction.execute();

       Employee employee = payrollDatabase.getEmployeeById(empId);

       UnionAffiliation af = (UnionAffiliation) employee.getAffiliation();
       Employee member = payrollDatabase.getEmployeeByMemberId(memberId);

       assertEquals(member,employee);

    }

    /**
     * 改变员工属性-->退出协会
     */
    @Test
    public void testChangeUnaffiliatedTransaction(){
        int empId = 2;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        int memberId = 4;
        double dues = 10;

        UnionAffiliation unionAffiliation = new UnionAffiliation(memberId,dues);

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);
        e.setAffiliation(unionAffiliation);

        payrollDatabase.addUnionMember(memberId,e);

        System.out.println(e.getAffiliation());

        ChangeUnaffiliatedTransaction changeUnaffiliatedTransation = new ChangeUnaffiliatedTransaction(empId);
        changeUnaffiliatedTransation.execute();
    }


}
