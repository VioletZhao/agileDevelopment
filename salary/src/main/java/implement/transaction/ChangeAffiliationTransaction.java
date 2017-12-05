package implement.transaction;

import implement.affiliation.Affiliation;
import implement.affiliation.NoAffiliation;
import implement.affiliation.UnionAffiliation;
import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/25.
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(){}

    public ChangeAffiliationTransaction(int empId){
        super(empId);
    }

    public void change(Employee e) {
        recordMemberShip(e);
        e.setAffiliation(getAffiliation());
    }

    protected abstract Affiliation getAffiliation();

    protected abstract void recordMemberShip(Employee e);
    
    
}
