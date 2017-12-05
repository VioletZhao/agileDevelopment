package implement.affiliation;

import implement.entity.ServiceCharge;
import implement.payday.PayCheck;
import implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 协会会员
 * Created by ZD on 2017/10/24.
 */
public class UnionAffiliation implements Affiliation {
    private long memberID;
    private double mDues;//会费
    private ConcurrentHashMap<Date, ServiceCharge> serviceCharges = new ConcurrentHashMap<Date, ServiceCharge>();

    public UnionAffiliation(){}

    public UnionAffiliation(long memberID,double mDues){
        this.mDues = mDues;
        this.memberID = memberID;
    }

    public double getmDues() {
        return mDues;
    }

    public long getMemberID() {
        return memberID;
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(ServiceCharge serviceCharge){
        serviceCharges.put(serviceCharge.getDate(),serviceCharge);
    }

    public double calculateDeductions(PayCheck payCheck) {
        double totalDues = 0;
        int fridays = NumberOfFridaysInPayPeriod(payCheck.getPayPeriodStartDate(),payCheck.getPayPeriodEndDate());
        totalDues = mDues*fridays;//每月固定费用

        //其他费用
        for (ServiceCharge charge:serviceCharges.values()){
            if (DateUtil.IsInPayPeriod(charge.getDate(),payCheck.getPayPeriodStartDate(),payCheck.getPayPeriodEndDate()))
                totalDues += charge.getAmount();
        }

        return totalDues;
    }

    /**
     * 支付周五天数
     * @param payPeriodStartDate
     * @param payPeriodEndDate
     * @return
     */
    private int NumberOfFridaysInPayPeriod(Date payPeriodStartDate, Date payPeriodEndDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(payPeriodStartDate);
        Calendar payPeriodEnd = Calendar.getInstance();
        payPeriodEnd.setTime(payPeriodEndDate);

        int firdays = 0;
        while (calendar.before(payPeriodEnd)){
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
                firdays++;
            }
            calendar.add(Calendar.DATE,1);
        }
        return firdays;
    }
}
