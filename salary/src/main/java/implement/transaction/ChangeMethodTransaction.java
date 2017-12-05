package implement.transaction;

import implement.entity.Employee;
import implement.method.PaymentMethod;

/**
 * Created by ZD on 2017/10/26.
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction  {

    public ChangeMethodTransaction(){}

    public ChangeMethodTransaction(int empId){
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setPaymentMethod(getPaymentMethod());
    }

    protected abstract PaymentMethod getPaymentMethod();
}
