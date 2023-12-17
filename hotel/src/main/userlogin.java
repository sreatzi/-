/*
 * Created by JFormDesigner on Mon Dec 11 22:20:22 CST 2023
 */

package main;

import dao.Dao;
import model.Operator;
import model.user;
import voidata.datagloer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class userlogin extends JFrame {
    private static user userid = null;

    public static user getUser()
    {
        return userid;
    }
    public userlogin() {
        initComponents();
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

            userlogin frame = new userlogin();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        System.out.println(textField2.getText());
        System.out.println(textField3.getText());
        user user = Dao.llogin(textField2.getText(),textField3.getText());
        if(user==null)
        {
            JOptionPane.showMessageDialog(null,"登陆失败");
        }else
        {
            JOptionPane.showMessageDialog(null, "登录成功!");

            datagloer.userid=user.getUserid();
             System.out.println(datagloer.userid);
            new userMain().setVisible(true);
            dispose();
        }
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField3 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/res/images/about-service.jpg")).getImage());
        setTitle("\u7528\u6237\u767b\u9646");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/res/images/hotel/offer01.jpg")));
        contentPane.add(label1);
        label1.setBounds(0, 0, 370, 225);
        contentPane.add(textField2);
        textField2.setBounds(150, 260, 130, textField2.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(70, 265), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(70, 315), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(150, 315, 130, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u767b\u9646");
        button1.addActionListener(e -> login(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(90, 370), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addActionListener(e -> cancel(e));
        contentPane.add(button2);
        button2.setBounds(210, 370, 80, 30);

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
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
