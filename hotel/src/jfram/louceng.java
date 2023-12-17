/*
 * Created by JFormDesigner on Tue Dec 12 11:31:40 CST 2023
 */

package jfram;

import dao.Dao;
import model.Room;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 86151
 */
public class louceng extends JInternalFrame {
    private String [] columnNames = {"房间号","房间类型","房间尺寸","房间状态","空调","WIFI"};
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel tableModel;
    private String bookISBNs = null;

    private String readerISBNs = null;

    public louceng() {
        initComponents();
        initData();
    }
   private Object[][] getFileroom(List list){
     Object [][] results = new Object[list.size()][columnNames.length];
     for (int i=0;i<list.size();i++)
     {
         Room room = (Room) list.get(i);
         results[i][0] = room.getRoomid();
         results[i][1] = room.getRoom();
         results[i][2] = room.getMsize();
         results[i][3] = room.getRoomstat();
         results[i][4] = room.getAirconditioning();
         results[i][5] = room.getWifi();
     }
       return results;

   }


    private void initData() {
        tableModel = new DefaultTableModel();
        Object[][] results = getFileroom(Dao.selectroom());
        tableModel.setDataVector(results, columnNames);
        separator1.setModel(tableModel);
        // 设置表头
    }

    private void button2() {
        // TODO add your code here
        Vector<String> roomid = Dao.getroom();
        System.out.println("触发我了" );
        if(roomid.isEmpty()){
            String roomstasts = "未";
            String newroom="0";
            System.out.println("暂无可用的roomid");
            int i = Dao.insertroom(newroom, (String) comboBox1.getSelectedItem(), (String) comboBox2.getSelectedItem(),roomstasts, (String) comboBox3.getSelectedItem(), (String) comboBox4.getSelectedItem());
        }else{
            String lastroomid = roomid.lastElement();
            int lastroomidNum = Integer.parseInt(lastroomid);
            int newroomid = lastroomidNum+1;
            String newroom=String.valueOf(newroomid);
            System.out.println(lastroomid);
            System.out.println(newroom);
            String roomstasts = "未";
            int i = Dao.insertroom(newroom, (String) comboBox1.getSelectedItem(), (String) comboBox2.getSelectedItem(),roomstasts, (String) comboBox3.getSelectedItem(), (String) comboBox4.getSelectedItem());
        }
        initData();
    }

    private void button1() {
        Room room = Dao.checkinroom(textField1.getText());
        if (room != null) {
            tableModel.setRowCount(0); // 清空表格原有数据
            System.out.println("yo");
            Object[][] results = new Object[1][columnNames.length];
            results[0][0] = room.getRoomid();
            results[0][1] = room.getRoom();
            results[0][2] = room.getMsize();
            results[0][3] = room.getRoomstat();
            results[0][4] = room.getAirconditioning();
            results[0][5] = room.getWifi();

            tableModel.setDataVector(results, columnNames);
            separator1.setModel(tableModel);
        } else {
            System.out.println("未找到相关房间");
        }

    }

    private void button4() {
//        textField2
       int i = Dao.updataroom(textField2.getText(),"未");
        if(i==1){
            JOptionPane.showMessageDialog(null, "退房成功");

        }else{
            JOptionPane.showMessageDialog(null, "退房失败");

        }
        initData();
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        separator1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel3 = new JPanel();
        label6 = new JLabel();
        button4 = new JButton();
        textField2 = new JTextField();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        comboBox4 = new JComboBox<>();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("\u9152\u5e97\u623f\u95f4");
        setVisible(true);
        setClosable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("\u67e5\u770b\u623f\u95f4"));
            panel2.setLayout(null);

            //---- button1 ----
            button1.setText("\u786e\u8ba4");
            button1.addActionListener(e -> button1());
            panel2.add(button1);
            button1.setBounds(375, 15, 80, 35);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(separator1);
            }
            panel2.add(scrollPane1);
            scrollPane1.setBounds(30, 50, 435, 90);

            //---- label1 ----
            label1.setText("\u8f93\u5165\u623f\u95f4\u53f7");
            panel2.add(label1);
            label1.setBounds(55, 20, 70, 25);
            panel2.add(textField1);
            textField1.setBounds(125, 20, 235, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("\u9000\u623f"));
            panel3.setLayout(null);

            //---- label6 ----
            label6.setText("\u8f93\u5165\u623f\u95f4\u53f7");
            panel3.add(label6);
            label6.setBounds(110, 20, label6.getPreferredSize().width, 25);

            //---- button4 ----
            button4.setText("\u786e\u5b9a");
            button4.addActionListener(e -> button4());
            panel3.add(button4);
            button4.setBounds(335, 15, button4.getPreferredSize().width, 30);
            panel3.add(textField2);
            textField2.setBounds(185, 15, 125, textField2.getPreferredSize().height);

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
        contentPane.add(panel3, BorderLayout.SOUTH);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u65b0\u589e\u623f\u95f4"));
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u623f\u95f4");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(30, 31), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u623f\u95f4\u5927\u5c0f");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(144, 30), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u662f\u5426\u6709\u7a7a\u8c03");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(275, 30), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u662f\u5426\u6709wfif");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(411, 29), label5.getPreferredSize()));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5927\u5e8a\u623f",
                "\u8c6a\u534e\u623f",
                "\u53cc\u4eba\u623f",
                "\u603b\u7edf\u5957\u623f",
                "\u6c5f\u666f\u623f",
                "loft\u590d\u5f0f\u623f"
            }));
            panel1.add(comboBox1);
            comboBox1.setBounds(16, 50, 71, comboBox1.getPreferredSize().height);

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "\u52a0\u5927"
            }));
            panel1.add(comboBox2);
            comboBox2.setBounds(138, 49, 75, 30);

            //---- comboBox3 ----
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "\u6709"
            }));
            panel1.add(comboBox3);
            comboBox3.setBounds(266, 48, 77, 30);

            //---- comboBox4 ----
            comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "\u6709"
            }));
            panel1.add(comboBox4);
            comboBox4.setBounds(395, 50, 82, 30);

            //---- button2 ----
            button2.setText("\u786e\u5b9a");
            button2.addActionListener(e -> button2());
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(275, 95), button2.getPreferredSize()));

            //---- button3 ----
            button3.setText("\u786e\u5b9a");
            panel1.add(button3);
            button3.setBounds(new Rectangle(new Point(390, 95), button3.getPreferredSize()));

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
        contentPane.add(panel1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable separator1;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel3;
    private JLabel label6;
    private JButton button4;
    private JTextField textField2;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
