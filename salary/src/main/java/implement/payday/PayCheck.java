package implement.payday;

import java.util.Date;
import java.util.Hashtable;

/**
 * Created by ZD on 2017/10/26.
 */
public class PayCheck {

    private Date payDate;
    private final Date payPeriodStartDate;//支付开始时间
    private double grossPay;//静资产
    private Hashtable<String,String> fields = new Hashtable<String, String>();
    private double detuctions;//会费
    private double netPay;//最后结余

    public PayCheck(Date payPeriodStartDate,Date payDate){
        this.payDate = payDate;
        this.payPeriodStartDate = payPeriodStartDate;
    }


    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public Hashtable<String, String> getFields() {
        return fields;
    }

    public double getDetuctions() {
        return detuctions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setFields(String fieldName,String value) {
        fields.put(fieldName,value);
    }

    public void setDetuctions(double detuctions) {
        this.detuctions = detuctions;
    }

    public Date getPayPeriodEndDate() {
        return payDate;
    }


}
