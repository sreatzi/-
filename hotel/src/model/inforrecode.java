package model;

import java.util.Date;

public class inforrecode {
    private String servepayid;
    private String payrecod;
    private Date recodedate;

    public void setServepayid(String servepayid){this.servepayid=servepayid;}
    public void setPayrecod(String payrecod){this.payrecod=payrecod;}
    public void setRecodedate(Date recodedate){this.recodedate=recodedate;}

    public String getServepayid(){return servepayid;}
    public String getPayrecod(){return payrecod;}
    public Date getRecodedate(){return recodedate;}
}
