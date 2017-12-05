package implement.transaction;

import implement.classification.PaymentClassification;
import implement.classification.SalariedClassification;
import implement.schedule.MonthlySchedule;
import implement.schedule.PaymentSchedule;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

    private double monthlyPay;

    public ChangeSalariedTransaction(){}

    public ChangeSalariedTransaction(double empId,double monthlyPay){
        super((int) empId);
        this.monthlyPay = monthlyPay;
    }

    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    protected PaymentClassification getClassification() {
        return new SalariedClassification(monthlyPay);
    }
}
