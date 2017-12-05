package implement.transaction;

import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

    long empId;
    String address;

    public ChangeAddressTransaction(){}

    public ChangeAddressTransaction(long empId,String address){
        super((int) empId);
        this.address = address;
    }

    public void change(Employee e) {
        e.setAddress(address);
    }
}
