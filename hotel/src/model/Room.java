package model;

public class Room
{
    private String roomid;
    private String room;
    private String msize;
    private String roomstat;
    private String airconditioning;
    private String wifi;

    public void setRoomid(String roomid){this.roomid=roomid;}
    public void setRoom(String room){this.room=room;}
    public void setMsize(String msize){this.msize=msize;}
    public void setRoomstat(String roomstat){this.roomstat=roomstat;}
    public void setAirconditioning(String airconditioning){this.airconditioning=airconditioning;}
    public void setWifi(String wifi){this.wifi=wifi;}

    public String getRoomid(){return roomid;}
    public String getRoom(){return room;}
    public String getMsize(){return msize;}
    public String getRoomstat(){return roomstat;}
    public String getAirconditioning(){return airconditioning;}
    public String getWifi(){return wifi;}

}
