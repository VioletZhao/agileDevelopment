package basemodel.template_strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZD on 2017/10/23.
 */
public class FtocRaw {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while (!done){
            String fahrString = br.readLine();
            if (fahrString == null || fahrString.length() == 0)
                done = true;
            else {
                double fahr = Double.parseDouble(fahrString);
                double celcius = 5.0/9.0*(fahr-32);
                System.out.println("F="+fahr+",C="+celcius);
            }
        }
        System.out.println("ftoc exit");
    }
}
