package com.zd.salaryPayment.template_strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZD on 2017/10/23.
 */
public class FtocTemplateMethod extends Application {

    private InputStreamReader isr;
    private BufferedReader br;

    public static void main(String[] args){
        (new FtocTemplateMethod()).run();
    }

    protected void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    protected void idle() {
        String fahrString = readLineAndReturnNullError();
        if (fahrString == null || fahrString.length() == 0){
            setDone();
        }
        else {
            double fahr = Double.parseDouble(fahrString);
            double celious = 5.0/9.0*(fahr - 32);
            System.out.println("F="+fahr+",C="+celious);
        }

    }

    private String readLineAndReturnNullError() {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            s = null;
        }
        return s;
    }

    protected void cleanup() {
        System.out.println("exit");
    }
}
