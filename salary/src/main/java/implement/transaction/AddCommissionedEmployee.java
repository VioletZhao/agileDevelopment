package implement.transaction;

import implement.classification.CommissionedClassification;
import implement.classification.PaymentClassification;
import implement.schedule.BiweeklySchedule;
import implement.schedule.PaymentSchedule;

/**
 * Created by ZD on 2017/10/24.
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction{

    private double monthlyPay;
    private double commissionRate;

    public AddCommissionedEmployee(long id,String name,String address,double monthlyPay,double commissionRate){
        super(id,name,address);
        this.commissionRate = commissionRate;
        this.monthlyPay = monthlyPay;
    }

    protected PaymentSchedule getSchdule() {
        return new BiweeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new CommissionedClassification(monthlyPay,commissionRate);
    }
}
