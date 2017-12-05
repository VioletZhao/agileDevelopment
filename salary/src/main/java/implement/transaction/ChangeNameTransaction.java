package implement.transaction;

import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/24.
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String name;

    public ChangeNameTransaction(){}

    public ChangeNameTransaction(long empID,String name){
        super((int) empID);
        this.name = name;
    }

    public void change(Employee e) {
        e.setName(name);
    }
}
