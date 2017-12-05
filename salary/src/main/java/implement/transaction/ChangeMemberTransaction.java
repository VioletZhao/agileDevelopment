package implement.transaction;

import implement.affiliation.Affiliation;
import implement.affiliation.NoAffiliation;
import implement.affiliation.UnionAffiliation;
import implement.database.PayrollDatabase;
import implement.entity.Employee;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int memberId;
    private double dues;//会费

    public ChangeMemberTransaction(long empId,int memberId,double dues){
        super((int) empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    public ChangeMemberTransaction(){}


    @Override
    protected UnionAffiliation getAffiliation() {
        return new UnionAffiliation(memberId,dues);
    }

    protected void recordMemberShip(Employee e) {
        PayrollDatabase.getPayrollDatabase().addUnionMember(memberId,e);
    }
}
