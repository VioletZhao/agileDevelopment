package implement.transaction;

import implement.method.DirectMethod;
import implement.method.PaymentMethod;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeDirectTransaction extends ChangeMethodTransaction {

    private String bank;
    private double account;

    public ChangeDirectTransaction(){}

    public ChangeDirectTransaction(int empId,String bank,double account){
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    protected PaymentMethod getPaymentMethod() {
        return new DirectMethod(bank,account);
    }
}
