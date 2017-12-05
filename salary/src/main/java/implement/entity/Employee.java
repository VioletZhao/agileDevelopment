package implement.entity;

import implement.affiliation.Affiliation;
import implement.affiliation.NoAffiliation;
import implement.affiliation.UnionAffiliation;
import implement.classification.PaymentClassification;
import implement.classification.SalariedClassification;
import implement.method.HoldMethod;
import implement.method.PaymentMethod;
import implement.payday.PayCheck;
import implement.schedule.MonthlySchedule;
import implement.schedule.PaymentSchedule;
import sun.security.krb5.internal.PAData;

import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class Employee {

    private int id;
    private String name;
    private String address;

    PaymentMethod paymentMethod;
    PaymentSchedule paymentSchedule;
    PaymentClassification paymentClassification;
    Affiliation affiliation;

    public Employee(long id, String name, String address) {
        this.id = (int) id;
        this.name = name;
        this.address = address;
        affiliation = new NoAffiliation();
    }

    public PaymentClassification getPaymentClassification() {
        return paymentClassification;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public PaymentMethod getPaymentMethod() {
        return  paymentMethod;
    }

    public void setClassification(PaymentClassification classification) {
        this.paymentClassification = classification;
    }

    public void setSchedule(PaymentSchedule schedule) {
        this.paymentSchedule = schedule;
    }

    public void setMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void payDay(PayCheck payCheck) {
        double grossPay = paymentClassification.calculatePay(payCheck);
        double deductions = affiliation.calculateDeductions(payCheck);
        double netPay = grossPay - deductions;
        payCheck.setGrossPay(grossPay);
        payCheck.setDetuctions(deductions);
        payCheck.setNetPay(netPay);
        paymentMethod.pay(payCheck);
    }

    public boolean isPayDate(Date date) {
        return paymentSchedule.isPayDate(date);
    }

    public Integer getEmpId() {
        return id;
    }

    public Date getPayPeriodSatrtDate(Date date) {
        return paymentSchedule.getPayPeriodStartDate(date);
    }
}
