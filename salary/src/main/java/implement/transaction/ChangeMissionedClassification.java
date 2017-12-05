package implement.transaction;

import implement.classification.CommissionedClassification;
import implement.classification.PaymentClassification;
import implement.schedule.BiweeklySchedule;
import implement.schedule.PaymentSchedule;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeMissionedClassification extends ChangeClassificationTransaction {

    private double salaryBase;
    private double commissionRate;

    public ChangeMissionedClassification(){}

    public ChangeMissionedClassification(long empId,double salaryBase,double commissionRate){
        super((int) empId);
        this.commissionRate = commissionRate;
        this.salaryBase = salaryBase;
    }

    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salaryBase,commissionRate);
    }
}
