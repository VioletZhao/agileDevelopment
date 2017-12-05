package implement.entity;

import java.util.Date;

/**
 *会费
 * Created by ZD on 2017/10/24.
 */
public class ServiceCharge {

    private Date date;
    private double amount;

    public ServiceCharge(){}

    public ServiceCharge(Date date,double amount){
        this.amount = amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
