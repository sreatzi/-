/*
 * Created by JFormDesigner on Tue Dec 12 11:41:37 CST 2023
 */

package jfram;

import dao.Dao;
import model.Room;
import voidata.datagloer;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

/**
 * @author 86151
 */
public class bookhotel extends JInternalFrame {
    public bookhotel() {
        initComponents();
        initCom();
    }

    private void button1() {
        // TODO add your code here
        System.out.println(datagloer.userid);
        System.out.println(comboBox2.getSelectedItem());
        System.out.println(textField1.getText());
         int i=Dao.addbookroom(datagloer.userid, String.valueOf(comboBox5.getSelectedItem()),textField1.getText());
         int b=Dao.updataroom(String.valueOf(comboBox5.getSelectedItem()), "有");
        if(i==1&&b==1){
            JOptionPane.showMessageDialog(null, "预订成功");
            doDefaultCloseAction();
        }
    }

    private void initCom(){
        Vector<String> rooms = Dao.getweiroom();
        System.out.println("Got all rooms: " + rooms);
        DefaultComboBoxModel model = new DefaultComboBoxModel(rooms);
        comboBox5.setModel(model);
    }

    private void comboBox5() {
        // TODO add your code here
        Room room1 = Dao.chackroom(String.valueOf(comboBox5.getSelectedItem()));
        System.out.println(room1.getRoom());
        textField2.setText(room1.getRoom());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        comboBox4 = new JComboBox<>();
        label7 = new JLabel();
        label8 = new JLabel();
        comboBox5 = new JComboBox();
        textField2 = new JTextField();

        //======== this ========
        setTitle("\u9884\u8ba2");
        setVisible(true);
        setClosable(true);
        setBackground(Color.white);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/res/images/clock.png")));
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.setBackground(Color.white);
            button1.addActionListener(e -> button1());
            panel1.add(button1);

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            button2.setBackground(Color.white);
            panel1.add(button2);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.white);
            panel2.setLayout(null);
            panel2.add(label2);
            label2.setBounds(new Rectangle(new Point(45, 20), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u623f\u95f4\u7c7b\u578b");
            label3.setForeground(Color.black);
            panel2.add(label3);
            label3.setBounds(new Rectangle(new Point(20, 75), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u9884\u8ba2\u65f6\u95f4");
            label4.setForeground(Color.black);
            panel2.add(label4);
            label4.setBounds(new Rectangle(new Point(215, 85), label4.getPreferredSize()));
            panel2.add(textField1);
            textField1.setBounds(275, 80, 75, textField1.getPreferredSize().height);

            //---- label5 ----
            label5.setText("\u662f\u5426\u52a0\u8bbe\u5907");
            label5.setBackground(Color.black);
            label5.setForeground(Color.black);
            panel2.add(label5);
            label5.setBounds(new Rectangle(new Point(15, 125), label5.getPreferredSize()));

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "wifi"
            }));
            panel2.add(comboBox2);
            comboBox2.setBounds(80, 120, 80, 30);

            //---- comboBox3 ----
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "\u52a0\u5927\u5c3a\u5bf8"
            }));
            panel2.add(comboBox3);
            comboBox3.setBounds(175, 120, 78, 30);

            //---- comboBox4 ----
            comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5426",
                "\u7a7a\u8c03"
            }));
            panel2.add(comboBox4);
            comboBox4.setBounds(270, 120, 78, 30);
            panel2.add(label7);
            label7.setBounds(new Rectangle(new Point(25, 35), label7.getPreferredSize()));

            //---- label8 ----
            label8.setText("\u623f\u95f4\u53f7");
            label8.setForeground(Color.black);
            panel2.add(label8);
            label8.setBounds(new Rectangle(new Point(25, 30), label8.getPreferredSize()));

            //---- comboBox5 ----
            comboBox5.addActionListener(e -> comboBox5());
            panel2.add(comboBox5);
            comboBox5.setBounds(new Rectangle(new Point(80, 25), comboBox5.getPreferredSize()));
            panel2.add(textField2);
            textField2.setBounds(80, 75, 85, textField2.getPreferredSize().height);

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
        contentPane.add(panel2, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JLabel label5;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JLabel label7;
    private JLabel label8;
    private JComboBox comboBox5;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
