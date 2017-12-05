package implement.affiliation;


import implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public class NoAffiliation implements Affiliation {

    public double calculateDeductions(PayCheck payCheck) {
        return 0;
    }
}
