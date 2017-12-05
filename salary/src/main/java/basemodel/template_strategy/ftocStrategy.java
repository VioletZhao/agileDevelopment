package basemodel.template_strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZD on 2017/10/23.
 */
public class ftocStrategy implements Application1 {

    private InputStreamReader isr;
    private BufferedReader br;
    private boolean isDone;

    public static void main(String[] args){
        (new ApplicationRunner(new ftocStrategy())).run();
    }

    public void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    public void idle() {
        String fahrString = readLineAndReturnNullError();
        if (fahrString == null || fahrString.length() == 0){
            isDone = true;
        }
        else {
            double fahr = Double.parseDouble(fahrString);
            double celcios = 5.0/9.0*(fahr-32);
            System.out.println("F="+fahr+",C="+celcios);
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

    public void cleanup() {
        System.out.println("clean");
    }

    public boolean done() {
        return isDone;
    }
}
