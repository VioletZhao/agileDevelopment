package implement.transaction;

import implement.affiliation.Affiliation;
import implement.affiliation.NoAffiliation;
import implement.affiliation.UnionAffiliation;
import implement.database.PayrollDatabase;
import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(){}

    public ChangeUnaffiliatedTransaction(int empId){
        super(empId);
    }

    protected NoAffiliation getAffiliation() {
        return new NoAffiliation();
    }

    protected void recordMemberShip(Employee e) {
        UnionAffiliation unionAffiliation = (UnionAffiliation) e.getAffiliation();
        int memberId = (int) unionAffiliation.getMemberID();
        PayrollDatabase.getPayrollDatabase().removeUnionMember(memberId);
    }
}
