package implement.classification;

import implement.entity.SalesReceipt;
import implement.payday.PayCheck;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZD on 2017/10/24.
 */
public class CommissionedClassification implements PaymentClassification {

    private double salaryBase;
    private double commissionRate;

    private ConcurrentHashMap<Date,SalesReceipt> salesReceipts = new ConcurrentHashMap<Date, SalesReceipt>();

    public CommissionedClassification(double salaryBase, double commissionRate) {
        this.salaryBase = salaryBase;
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getDate(),salesReceipt);
    }

    public SalesReceipt getSalesReceipt(Date date) {
        return salesReceipts.get(date);
    }

    public double calculatePay(PayCheck payCheck) {
        double salesTotal = 0.0;
        return 0;
    }
}
