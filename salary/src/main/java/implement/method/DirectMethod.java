package implement.method;

import implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/26.
 */
public class DirectMethod implements PaymentMethod {

    private String bank;
    private double account;


    public DirectMethod(String bank, double account) {
        this.bank = bank;
        this.account = account;
    }

    public DirectMethod(){}


    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Direct");
    }
}
