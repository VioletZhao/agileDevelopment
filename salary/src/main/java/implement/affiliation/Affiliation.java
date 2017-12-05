package implement.affiliation;


import implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public interface Affiliation {
    NoAffiliation NO_AFFILIATION = new NoAffiliation();

    double calculateDeductions(PayCheck payCheck);
}
