package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Dao {
    private static String dbClassName = "com.mysql.cj.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/hotel";
    private static String dbUser = "root";
    private static String dbPwd = "123456";

    private static List bookTypes;

    private static Connection conn = null;

    Dao(){
        try
        {
         if(conn==null)
         {
             Class.forName(dbClassName);
             conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
         }
         else return;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close()
    {
      try
      {
        if(conn!=null) conn.close();
      }
      catch(Exception e){
          e.printStackTrace();
      }
      finally{
          conn = null;
      }
    }



    private static int executeUpdate(String sql)
    {
        try
        {
            if (conn==null) new Dao();
            return conn.createStatement().executeUpdate(sql);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    public static Vector<String> getserve()
    {
        List list = Dao.selectserve();
        Vector<String> serves = new Vector<String>();

        for(int i=0;i<list.size();i++)
        {
            serve serve = (serve) list.get(i);
            serves.add(serve.getServeid());
        }
        return serves;
    }

    public static Vector<String> getroom(){
        List list = Dao.selectroom();
        Vector<String> rooms = new Vector<>();

        for (int i = 0;i<list.size();i++){
            Room roomid = (Room) list.get(i);
            rooms.add(roomid.getRoomid());
        }
        return rooms;
    }
    public static Vector<String> getrecording(){
        List list = Dao.recording();
        Vector<String> recordings = new Vector<>();
         for (int i=0;i<list.size();i++){
             recording payid = (recording) list.get(i);
             recordings.add(payid.getPayid());
         }
        return recordings;
    }

    public static List recording() {
   List list = new ArrayList<>();
   String sql = "select * from recording";
   ResultSet rs = Dao.executeQuery(sql);
   try{
       while (rs.next()){
        recording recording = new recording();
        recording.setPayid(rs.getString("payid"));
        recording.setMoney(rs.getString("money"));
        recording.setPeydata(rs.getDate("peydata"));
        recording.setUserid(rs.getString("userid"));
        list.add(recording);
       }
   }catch (SQLException e){
       e.printStackTrace();
   }
        return list;
    }

    public static Vector<String> getall(){
        List list = Dao.allpay();
        Vector<String> allpay = new Vector<>();
        for (int i=0;i<list.size();i++){
            allpay allpayid = (allpay) list.get(i);
            allpay.add(allpayid.getAllid());
        }
        return allpay;
    }
    public static List allpay() {
        List list = new ArrayList<>();
        String sql = "select * from allpay";
        ResultSet rs = Dao.executeQuery(sql);
        try{
            while (rs.next()){
                allpay allpay = new allpay();
                allpay.setAllid(rs.getString("allid"));
                allpay.setAllmoney(rs.getString("allmoney"));
                list.add(allpay);
                System.out.println("allid: " + allpay.getAllid());
                System.out.println("allmoney: " + allpay.getAllmoney());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public static List checkserveall(String userid)
    {
        List list = new ArrayList<>();
        String sql = "select * from recording where userid ="+userid;
        System.out.println(sql);
        ResultSet rs = Dao.executeQuery(sql);
        try{
            while (rs.next()){
                recording recording = new recording();
                recording.setMoney(rs.getString("money"));
                list.add(recording);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
    public static List selectroom(){
        List list = new ArrayList<>();
        String sql = "select * from room";
        ResultSet rs = Dao.executeQuery(sql);
        try{
            while (rs.next())
            {
                Room room = new Room();
                room.setRoomid(rs.getString("roomid"));
                room.setRoom(rs.getString("room"));
                room.setMsize(rs.getString("msize"));
                room.setRoomstat(rs.getString("roomstat"));
                room.setAirconditioning(rs.getString("airconditioning"));
                room.setWifi(rs.getString("wifi"));
                list.add(room);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public static List selectserve(){
        List list = new ArrayList();
        String sql = "SELECT * from serve";
        ResultSet rs = Dao.executeQuery(sql);
        try{
            while(rs.next()){
              serve serve = new serve();
                serve.setServeid(rs.getString("serveid"));
                serve.setServetype(rs.getString("servetype"));
                serve.setServeall(rs.getString("serveall"));
                serve.setServedata(rs.getDate("servedata"));
                serve.setUserid(rs.getString("userid"));
                list.add(serve);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }



    public static int insertrecording(String payid, String money, String peydata, String userid) {
        int i = 0;
        try {
            String sql = "INSERT INTO recording (payid, money, peydata, userid) VALUES ('" + payid + "', '" + money + "', '" + peydata + "', '" + userid + "')";
            i = Dao.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int insertroom(String roomid, String room, String msize, String roomstat, String airconditioning, String wifi) {
        int i = 0;
        try {
            String sql = "INSERT INTO room (roomid, room, msize, roomstat, airconditioning, wifi) VALUES ('" + roomid + "', '" + room + "', '" + msize + "', '" + roomstat + "', '" + airconditioning + "', '" + wifi + "')";
            i = Dao.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int updataroom(String roomid1,String roomstat){
        int i = 0;
        try{
            String sql = "UPDATE room SET roomstat = '" + roomstat + "' WHERE roomid = '" + roomid1 + "'";
            i = Dao.executeUpdate(sql);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public static int addserve(String serveid, Object servetype, String serveall, String servedata, String userid){
        int i =0;
        try{
            String sql = "INSERT INTO serve (serveid, servetype, serveall, servedata, userid) "
                    + "VALUES ('" + serveid + "', '" + servetype + "', '" + serveall + "', '" + servedata + "', '" + userid + "')";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public static int addbookroom(String userid1,String roomid1,String booktime){
    int i = 0;

        try{
            String sql = "INSERT INTO book (userid1, roomid1, booktime) VALUES ('" + userid1 + "', '" + roomid1 + "', '" + booktime + "')";
           System.out.println(sql);
            i = Dao.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }
    public static int deleserve(String serveid){
        int i = 0;

        try{
            String sql = "DELETE FROM serve WHERE serveid = '" + serveid + "'";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }

    public static int delepay(String userid){
        int i = 0;

        try{
            String sql = "DELETE FROM recording WHERE userid = '" + userid + "'";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }

    public static int addall(String allid,String allmoney){
        int i = 0;

        try{
            String sql = "INSERT INTO allpay (allid, allmoney) VALUES ('" + allid + "', '" + allmoney + "')";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }

    public static serve checkserve(String serveid)
    {
        int i = 0;
        serve serve = new serve();
        String sql = "select * from serve where serveid ="+serveid;
        try{
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next()){
                serve.setServeall(rs.getString("serveall"));
                serve.setUserid(rs.getString("userid"));
            }else
                return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return serve;
    }



    public static Room chackroom(String roomid)
    {
        int i =0;
        Room room1 = new Room();
        String sql = "select * from room where roomid ="+roomid;
        try{
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next())
            {

                room1.setRoom(rs.getString("room"));
            }
            else
                return null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return room1;
    }

    public static allpay checkall(String allid){
        int i = 0;
        allpay allpay = new allpay();
        String sql = "select * from allpay where allid ="+allid;
        System.out.println(sql);
        try{
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next())
            {
                allpay.setAllid(rs.getString("allid"));
                allpay.setAllmoney(rs.getString("allmoney"));
            }
            else
                return null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return allpay;
    }

    public static recording cheackre(String userid){
        int i = 0;
        recording recording = new recording();
        String sql = "select * from recording where payid ="+userid;
        System.out.println(sql);
        try{
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next())
            {
                recording.setPayid(rs.getString("payid"));
                recording.setMoney(rs.getString("money"));
                recording.setPeydata(rs.getDate("peydata"));
                recording.setUserid(rs.getString("userid"));
            }
            else
                return null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return recording;
    }

    public static Room checkinroom(String roomid)
    {
        int i =0;
        Room room1 = new Room();
        String sql = "select * from room where roomid ="+roomid;
        try{
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next())
            {
                room1.setRoomid(rs.getString("roomid"));
                room1.setRoom(rs.getString("room"));
                room1.setMsize(rs.getString("msize"));
                room1.setRoomstat(rs.getString("roomstat"));
                room1.setAirconditioning(rs.getString("airconditioning"));
                room1.setWifi(rs.getString("wifi"));
            }
            else
                return null;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return room1;
    }
    public static user llogin(String userid,String name){
     int i =0;
     user user = new user();
     String sql = "select * from user where userid = '" + userid + "' and name = '" + name + "'";
     try{
         ResultSet rs = Dao.executeQuery(sql);
         if (rs.next())
         {
             user.setUserid(rs.getString("userid"));
             user.setName(rs.getString("name"));
         }
         else
             return null;
     }catch (Exception e){
         e.printStackTrace();
     }
     return user;
    }

    public static List<Room> selectHotel() {
        List<Room> list = new ArrayList<>();
        System.out.println("Executing selectHotel()");
        String sql = "select * from room";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Room room = new Room();
                room.setRoom(rs.getString("room"));
                room.setRoomid(rs.getString("roomid"));
                room.setMsize(rs.getString("msize"));
                room.setRoomstat(rs.getString("roomstat"));
                room.setAirconditioning(rs.getString("airconditioning"));
                room.setWifi(rs.getString("wifi"));
                list.add(room); // 将room对象添加到list中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Selected hotel records: " + list);
        return list;
    }


    public static Vector<String> getALLroom()
    {
        List list = Dao.selectHotel();
        Vector<String> rooms = new Vector<>();
        for(int i = 0;i<list.size();i++)
        {
            Room room = (Room) list.get(i);
            rooms.add(room.getRoomid());
        }
        return rooms;
    }

    public static List<Room> selectHotelwei() {
        List<Room> list = new ArrayList<>();
        System.out.println("Executing selectHotel()");
        String sql = "select * from room WHERE roomstat = '未' ";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Room room = new Room();
                room.setRoom(rs.getString("room"));
                room.setRoomid(rs.getString("roomid"));
                room.setMsize(rs.getString("msize"));
                room.setRoomstat(rs.getString("roomstat"));
                room.setAirconditioning(rs.getString("airconditioning"));
                room.setWifi(rs.getString("wifi"));
                list.add(room); // 将room对象添加到list中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Selected hotel records: " + list);
        return list;
    }


    public static Vector<String> getweiroom()
    {
        List list = Dao.selectHotelwei();
        Vector<String> rooms = new Vector<>();
        for(int i = 0;i<list.size();i++)
        {
            Room room = (Room) list.get(i);
            rooms.add(room.getRoomid());
        }
        return rooms;
    }


    public  static Operator check(String username, String password)
    {
        int i = 0;
        Operator operator = new Operator();
        String sql = "select * from admin where user = '" + username + "' and password = '" + password + "'";
        try
        {
            ResultSet rs = Dao.executeQuery(sql);
            if (rs.next())
            {
                operator.setPassword(rs.getString("password"));
                operator.setUser(rs.getString("user"));
            }
            else   return null;

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        Dao.close();
        return operator;
    }
    private static ResultSet executeQuery(String sql)
    {
        try
        {
            if (conn==null) new Dao();
            return conn.createStatement().executeQuery(sql);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
