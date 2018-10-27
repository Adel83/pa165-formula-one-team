package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.entity.base.BaseEntity;
import java.util.Date;


/**
 * @author Adel Chakouri
 */

public class Race extends BaseEntity {


    private Date date;
    private String title;
    private String Location;


    public Date getDate(){return date;}
    public void setDate(Date date){this.date=date;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

    public String getLocation(){return Location;}
    public void setLocation(String location){this.Location=Location;}

    public String toString() {
        return "Race{" +
                "date='" + getDate() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", Location='" + getLocation() + '\'' +
                "} " + super.toString();
    }

}
