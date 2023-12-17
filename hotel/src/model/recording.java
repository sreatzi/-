package model;

import java.util.Date;

public class recording {
    private String payid;
    private String money;
    private Date peydata;
    private String userid;

    public void setPayid(String payid){this.payid=payid;}
    public void setMoney(String money){this.money=money;}
    public void setPeydata(Date peydata){this.peydata=peydata;}
    public void setUserid(String payall){this.userid=payall;}

    public String getPayid(){return payid;}
    public String getMoney(){return money;}
    public Date getPeydata(){return peydata;}
    public String getUserid(){return userid;}
}
