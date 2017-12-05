package implement.entity;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 销售记录
 * 只有带薪员工才有
 * Created by ZD on 2017/10/24.
 */
public class SalesReceipt {

    private Date date;
    private int amount;

    public SalesReceipt(){}

    public SalesReceipt(Date date,int amount){
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
