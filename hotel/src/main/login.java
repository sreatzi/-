/*
 * Created by JFormDesigner on Mon Dec 11 20:08:12 CST 2023
 */

package main;

import dao.Dao;
import model.Operator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class login extends JFrame {
    private static Operator user = null;

    public static Operator getUser()
    {
        return user;
    }
    public static void main(String[] args) {
        {
            try {

                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            login frame = new login();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    public login() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        System.out.println(textField1.getText());
        System.out.println(textField2.getText());
        Operator operator = Dao.check(textField1.getText(),textField2.getText());
        if(operator==null)
        {
            JOptionPane.showMessageDialog(null,"登陆失败");
        }else
        {

            JOptionPane.showMessageDialog(null, "登录成功!");
            user = operator;
            new Main().setVisible(true);
            dispose();
        }
    }

    private void button2(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label2 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf-\u7ba1\u7406\u5458");
        setIconImage(new ImageIcon(getClass().getResource("/res/images/hotel/dateIco.png")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        contentPane.add(label2);
        label2.setBounds(140, 230, 60, 30);

        //---- label1 ----
        label1.setText("text");
        label1.setIcon(new ImageIcon(getClass().getResource("/res/images/index.jpg")));
        contentPane.add(label1);
        label1.setBounds(0, -5, 455, 210);
        contentPane.add(textField1);
        textField1.setBounds(220, 230, 135, 30);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(140, 280, 45, 30);
        contentPane.add(textField2);
        textField2.setBounds(220, 280, 135, 30);

        //---- button1 ----
        button1.setText("\u767b\u9646");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(130, 335), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(280, 335), button2.getPreferredSize()));

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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
