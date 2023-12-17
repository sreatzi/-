/*
 * Created by JFormDesigner on Tue Dec 12 11:43:16 CST 2023
 */

package jfram;

import dao.Dao;
import model.serve;
import voidata.datagloer;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author 86151
 */
public class needserve extends JInternalFrame {
    public needserve() {
        initComponents();
    }

    private void button1() {
        Vector<String> serves = Dao.getserve();
        System.out.println(comboBox1.getSelectedItem());
        System.out.println(textField1.getText());
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(currentTime);
        System.out.println("当前时间：" + formattedTime);
        if (serves.isEmpty()) {
            System.out.println("没有可用的serveid");
            String newServeId = "1"; // 设置新serveid为1
            System.out.println("最后一个serveid：无");
            System.out.println("新serveid：" + newServeId);
            int i = Dao.addserve(newServeId,comboBox1.getSelectedItem(),textField1.getText(),formattedTime,datagloer.userid);
            if(i==1){

                JOptionPane.showMessageDialog(null, "添加成功");
                doDefaultCloseAction();
            }
            else{
                JOptionPane.showMessageDialog(null, "添加失败");
            }
        } else {
            String lastServeId = serves.lastElement(); // 获取最后一个serveid
            int lastServeIdNum = Integer.parseInt(lastServeId); // 转换为整数
            int newServeIdNum = lastServeIdNum + 1; // 加1
            String newServeId = String.valueOf(newServeIdNum); // 转换为字符串
            System.out.println("最后一个serveid：" + lastServeId);
            System.out.println("新serveid：" + newServeId);
            int i = Dao.addserve(newServeId,comboBox1.getSelectedItem(),textField1.getText(),formattedTime,datagloer.userid);
            if(i==1){

                JOptionPane.showMessageDialog(null, "添加成功");
                doDefaultCloseAction();
            }else{
                JOptionPane.showMessageDialog(null, "添加失败");
            }
        }

        System.out.println(datagloer.userid);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBox1 = new JComboBox<>();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u9700\u6c42\u670d\u52a1");
        setVisible(true);
        setClosable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9700\u6c42\u79cd\u7c7b");
        contentPane.add(label1);
        label1.setBounds(25, 15, 60, 20);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u9910\u98df",
            "\u63a5\u673a",
            "\u5065\u8eab",
            "\u6d17\u8863",
            "\u4f1a\u8bae",
            "\u9001\u673a",
            "\u9884\u8ba2\u65c5\u6e38\u666f\u70b9"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(85, 10), comboBox1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u9884\u7b97");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 100), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(65, 95, 75, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1());
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(120, 160), button1.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBox1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
