package implement.transaction;

import implement.method.MailMethod;
import implement.method.PaymentMethod;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeMailMethodTransaction extends ChangeMethodTransaction{

    private String mailAdress;

    public ChangeMailMethodTransaction(){}

    public ChangeMailMethodTransaction(int empId,String mailAdress){
        super(empId);
        this.mailAdress = mailAdress;
    }

    protected PaymentMethod getPaymentMethod() {
        return new MailMethod(mailAdress);
    }
}
