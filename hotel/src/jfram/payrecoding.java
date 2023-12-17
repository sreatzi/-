/*
 * Created by JFormDesigner on Tue Dec 12 11:40:30 CST 2023
 */

package jfram;

import dao.Dao;
import model.allpay;
import model.recording;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 86151
 */
public class payrecoding extends JInternalFrame {
    public payrecoding() {
        initComponents();
        chu();
        allpay();
    }
    private String[] columnNamesee ={"通过单号","消费","消费时间","客户ID"};
    private  String[] columnNamees={"汇总id","总消费"};
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    private Object[][] getallpay(List list){
        Object[][] results = new Object[list.size()][columnNamees.length];
        for (int i=0;i<list.size();i++){
            allpay allpay =(allpay)list.get(i);
            results[i][0] = allpay.getAllid();
            results[i][1]= allpay.getAllmoney();
        }
        return results;
    }

    private void allpay(){
        tableModel1 = new DefaultTableModel();
        Object[][] results = getallpay(Dao.allpay());
        tableModel1.setDataVector(results, columnNamees);
        label4.setModel(tableModel1);
    }

    private Object[][] getrecording(List list){
        Object[][] results = new Object[list.size()][columnNamesee.length];
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
        tableModel.setDataVector(results, columnNamesee);
        button1.setModel(tableModel);
    }

    private void label2() {
//        textField1
     recording recording = Dao.cheackre(textField1.getText());
        if (recording != null) {
            tableModel.setRowCount(0);

            // 将找到的房间信息加入表格
            Object[][] results = new Object[1][columnNamesee.length];
            results[0][0] = recording.getPayid();
            results[0][1] = recording.getMoney();
            results[0][2] = recording.getPeydata();
            results[0][3] = recording.getUserid();
            tableModel.setDataVector(results, columnNamesee);
            button1.setModel(tableModel);
        } else {
            System.out.println("未找到相关单号");
        }
//        chu();

        // TODO add your code here
    }

    private void button2() {
        allpay allpay = Dao.checkall(textField2.getText());
        if (allpay != null) {
            tableModel1.setRowCount(0);

            // 将找到的房间信息加入表格
            Object[][] results = new Object[1][columnNamees.length];
            results[0][0] = allpay.getAllid();
            results[0][1] = allpay.getAllmoney();

            tableModel1.setDataVector(results, columnNamees);
            label4.setModel(tableModel1);
        } else {
            System.out.println("未找到相关单号");
        }
//        chu();

        // TODO add your code here
//        textField2
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        button1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JButton();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label3 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();
        label4 = new JTable();

        //======== this ========
        setTitle("\u6d88\u8d39\u8bb0\u5f55");
        setVisible(true);
        setClosable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u6d88\u8d39\u67e5\u770b"));
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(button1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(5, 40, 470, 80);

            //---- label1 ----
            label1.setText("\u8bf7\u8f93\u5165\u901a\u8fc7\u5355\u53f7");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(45, 15), label1.getPreferredSize()));
            panel1.add(textField1);
            textField1.setBounds(135, 15, 95, 20);

            //---- label2 ----
            label2.setText("\u786e\u5b9a");
            label2.addActionListener(e -> label2());
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(290, 10), label2.getPreferredSize()));

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

        //======== panel2 ========
        {
            panel2.setLayout(null);

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
        contentPane.add(panel2, BorderLayout.SOUTH);

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("\u6c47\u603b\u67e5\u770b"));
            panel3.setLayout(null);

            //---- label3 ----
            label3.setText("\u8f93\u5165\u670d\u52a1\u8d39id\u6216\u8005\u6d88\u8d39\u8bb0\u5f55id");
            panel3.add(label3);
            label3.setBounds(new Rectangle(new Point(30, 25), label3.getPreferredSize()));
            panel3.add(textField2);
            textField2.setBounds(195, 20, 105, textField2.getPreferredSize().height);

            //---- button2 ----
            button2.setText("\u786e\u5b9a");
            button2.addActionListener(e -> button2());
            panel3.add(button2);
            button2.setBounds(new Rectangle(new Point(325, 20), button2.getPreferredSize()));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(label4);
            }
            panel3.add(scrollPane2);
            scrollPane2.setBounds(5, 55, 465, 125);

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
    private JScrollPane scrollPane1;
    private JTable button1;
    private JLabel label1;
    private JTextField textField1;
    private JButton label2;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label3;
    private JTextField textField2;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JTable label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
