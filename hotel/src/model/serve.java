package model;

import java.util.Date;

public class serve {
    private String serveid;
    private String servetype;
    private String serveall;
    private Date servedata;
    private String userid;

    public void setServeid(String serveid){this.serveid=serveid;}
    public void setServetype(String servetype){this.servetype=servetype;}
    public void setServeall(String serveall){this.serveall=serveall;}
    public void setServedata(Date servedata){this.servedata=servedata;}
    public void setUserid(String userid){this.userid=userid;}

    public String getServeid(){return serveid;}
    public String getServetype(){return servetype;}
    public String getServeall(){return serveall;}
    public String getUserid(){return userid;}
    public Date getServedata(){return servedata;}
}
