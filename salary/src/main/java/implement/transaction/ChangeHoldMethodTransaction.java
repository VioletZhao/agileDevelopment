package implement.transaction;

import implement.method.HoldMethod;
import implement.method.PaymentMethod;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeHoldMethodTransaction extends ChangeMethodTransaction{

    public ChangeHoldMethodTransaction(){}

    public ChangeHoldMethodTransaction(int empId){
        super(empId);
    }


    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
