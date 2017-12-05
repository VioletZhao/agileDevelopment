package implement.classification;

import implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public class SalariedClassification implements PaymentClassification {

    private double monthlyPay;

    public SalariedClassification(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }


    public double calculatePay(PayCheck payCheck) {
        return monthlyPay;
    }
}
