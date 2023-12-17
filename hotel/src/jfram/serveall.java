/*
 * Created by JFormDesigner on Tue Dec 12 11:37:18 CST 2023
 */

package jfram;

import dao.Dao;
import model.recording;
import model.serve;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 86151
 */
public class serveall extends JInternalFrame {
    private String[] columnNames = {"服务单号","服务种类","服务预算","服务时间","客户ID"};
    private String[] columnNamees = {"通过单号","消费","消费时间","客户ID"};
    DefaultTableModel tableModel;
    public serveall() {
        initComponents();
        initData();
        chu();
    }


   private Object[][] getrecording(List list){
        Object[][] results = new Object[list.size()][columnNamees.length];
        for (int i=0;i<list.size();i++){
            recording recording =(recording)list.get(i);

            results[i][0] = recording.getPayid();
            results[i][1]= recording.getMoney();
            results[i][2]= recording.getPeydata();
            results[i][3]= recording.getUserid();
        }
       return results;
   }

   private void chu(){
       tableModel = new DefaultTableModel();
       Object[][] results = getrecording(Dao.recording());
       tableModel.setDataVector(results, columnNamees);
       button5.setModel(tableModel);
   }


    private Object[][] getserve(List list){
        Object[][] results = new Object[list.size()][columnNames.length];
        for (int i=0;i<list.size();i++){
            serve serve = (serve)list.get(i);

            results[i][0] = serve.getServeid();
            results[i][1]= serve.getServetype();
            results[i][2]= serve.getServeall();
            results[i][3]= serve.getServedata();
            results[i][4]= serve.getUserid();
        }
       return results;
    }
    private void initData() {
        tableModel = new DefaultTableModel();
        Object[][] results = getserve(Dao.selectserve());
        tableModel.setDataVector(results, columnNames);
        label2.setModel(tableModel);
        // 设置表头
    }

    private void button1() {
        String serveall = null;
        String userid = null;
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(currentTime);
        System.out.println("当前时间：" + formattedTime);
        serve serve = Dao.checkserve(textField1.getText());
            int B = Dao.deleserve(textField1.getText());
        if (serve != null) {
            serveall=serve.getServeall();
            userid = serve.getUserid();
        } else {
            System.out.println("Serve not found.");
        }
        System.out.println(serveall);
        System.out.println(userid);
        Vector<String> payid = Dao.getrecording();
        if(payid.isEmpty()){
            String roomstasts = "未";
            String newroom="1";
            int i = Dao.insertrecording(newroom,serveall,formattedTime,userid);
        }else{
            String lastroomid = payid.lastElement();
            int lastroomidNum = Integer.parseInt(lastroomid);
            int newroomid = lastroomidNum+1;
            String newroom=String.valueOf(newroomid);
            System.out.println(lastroomid);
            System.out.println(newroom);
            String roomstasts = "未";
            int i = Dao.insertrecording(newroom,serveall,formattedTime,userid);
        }
        initData();
        chu();
    }

    private void button6() {
        Vector<String> recording = Dao.getall();
        String serveall =null;
        if(recording.isEmpty()){
            String roomstasts = "未";
            String newroom="1";
            serveall=newroom;
        }else{
            String lastroomid = recording.lastElement();
            int lastroomidNum = Integer.parseInt(lastroomid);
            int newroomid = lastroomidNum+1;
            String newroom=String.valueOf(newroomid);
            System.out.println(lastroomid);
            System.out.println(newroom);
            String roomstasts = "未";
            serveall=newroom;
        }
        List<recording> serves=Dao.checkserveall(textField4.getText());

        int c = Dao.delepay(textField4.getText());
        int sum = 0;
        for (recording s : serves) {
            int serveAll = Integer.parseInt(s.getMoney());
            System.out.println(serveAll);
            sum += serveAll;
        }
        System.out.println("Sum of Serve All: " + sum);
        int i = Dao.addall(serveall, String.valueOf(sum));
        initData();
        chu();
        // TODO add your code here

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        button1 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        label2 = new JTable();
        panel3 = new JPanel();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        button5 = new JTable();
        label7 = new JLabel();
        textField4 = new JTextField();
        button6 = new JButton();

        //======== this ========
        setTitle("\u9152\u5e97\u670d\u52a1");
        setVisible(true);
        setClosable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u670d\u52a1\u901a\u8fc7"));
            panel1.setLayout(null);

            //---- button1 ----
            button1.setText("\u5b8c\u6210");
            button1.addActionListener(e -> button1());
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(270, 15), button1.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u8f93\u5165\u670d\u52a1\u5355\u53f7");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(55, 20), label1.getPreferredSize()));
            panel1.add(textField1);
            textField1.setBounds(135, 15, 110, 25);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(label2);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(5, 45, 490, 70);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("\u670d\u52a1\u6c47\u603b"));
            panel3.setLayout(null);

            //---- label6 ----
            label6.setText("text");
            panel3.add(label6);
            label6.setBounds(new Rectangle(new Point(-20, -413), label6.getPreferredSize()));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(button5);
            }
            panel3.add(scrollPane2);
            scrollPane2.setBounds(5, 55, 490, 94);

            //---- label7 ----
            label7.setText("\u8f93\u5165\u5ba2\u4ebaid");
            panel3.add(label7);
            label7.setBounds(new Rectangle(new Point(60, 30), label7.getPreferredSize()));
            panel3.add(textField4);
            textField4.setBounds(140, 25, 95, textField4.getPreferredSize().height);

            //---- button6 ----
            button6.setText("\u6c47\u603b");
            button6.addActionListener(e -> button6());
            panel3.add(button6);
            button6.setBounds(new Rectangle(new Point(260, 25), button6.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton button1;
    private JLabel label1;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTable label2;
    private JPanel panel3;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JTable button5;
    private JLabel label7;
    private JTextField textField4;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
