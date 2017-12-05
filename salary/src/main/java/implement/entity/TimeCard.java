package implement.entity;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class TimeCard {

    private Date date;
    private double hours;

    public TimeCard(){}

    public TimeCard(Date date,double hours){
        this.date = date;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }


}
