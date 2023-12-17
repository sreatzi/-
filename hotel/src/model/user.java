package model;
import sun.dc.pr.PRError;

import java.sql.*;
import java.util.Date;

public class user {
    private String userid;
    private String name;
    private String phone;
    private Date roomdata;
    private String bookinfo;

    public void setUserid(String userid){this.userid=userid;}
    public void setName(String name){this.name=name;}
    public void setPhone(String phone){this.phone=phone;}
    public void setRoomdata(Date roomdata){this.roomdata=roomdata;}
    public void setBookinfo(String bookinfo){this.bookinfo=bookinfo;}

    public String getPhone(){return phone;}
    public Date getRoomdata(){return roomdata;}
    public String getBookinfo(){return bookinfo;}
    public String getUserid(){return userid;}
    public String getName(){return name;}
}
