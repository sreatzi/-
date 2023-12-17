/*
 * Created by JFormDesigner on Tue Dec 12 11:42:10 CST 2023
 */

package jfram;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import room.*;
/**
 * @author 86151
 */
public class checkroom extends JInternalFrame {
    public checkroom() {
        initComponents();
    }

    private void big(ActionEvent e) {
        // TODO add your code here
        new single().setVisible(true);
    }


    private void button3(ActionEvent e) {
        // TODO add your code here

    }



    private void button4(ActionEvent e) {
        // TODO add your code here
        System.out.println("NI");
        new viproom().setVisible(true);
    }



    private void button5(ActionEvent e) {
        // TODO add your code here
        System.out.println("NI1");
        new zong().setVisible(true);
    }

    private void button8() {
        // TODO add your code here
        System.out.println("NI2");
        new doubleroom().setVisible(true);
    }

    private void button7() {
        // TODO add your code here
        System.out.println("NI3");
        new loftroom().setVisible(true);
    }

    private void button6() {
        // TODO add your code here
        System.out.println("NI4");
        new riverroom().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label4 = new JLabel();
        panel1 = new JPanel();
        button2 = new JButton();
        panel2 = new JPanel();
        button1 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        setTitle("\u67e5\u770b\u623f\u578b");
        setVisible(true);
        setClosable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label4 ----
        label4.setIcon(new ImageIcon(getClass().getResource("/res/images/hotel/big_star_on.png")));
        contentPane.add(label4, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            panel1.add(button2);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            //---- button1 ----
            button1.setText("\u5927\u5e8a\u623f");
            button1.addActionListener(e -> big(e));
            panel2.add(button1);
            button1.setBounds(new Rectangle(new Point(30, 25), button1.getPreferredSize()));

            //---- button4 ----
            button4.setText("\u8c6a\u534e\u95f4");
            button4.addActionListener(e -> button4(e));
            panel2.add(button4);
            button4.setBounds(new Rectangle(new Point(295, 25), button4.getPreferredSize()));

            //---- button5 ----
            button5.setText("\u603b\u5957\u5957\u623f");
            button5.addActionListener(e -> button5(e));
            panel2.add(button5);
            button5.setBounds(new Rectangle(new Point(35, 125), button5.getPreferredSize()));

            //---- button6 ----
            button6.setText("\u6c5f\u666f\u623f");
            button6.addActionListener(e -> button6());
            panel2.add(button6);
            button6.setBounds(new Rectangle(new Point(165, 125), button6.getPreferredSize()));

            //---- button7 ----
            button7.setText("loft\u590d\u5f0f\u623f");
            button7.addActionListener(e -> button7());
            panel2.add(button7);
            button7.setBounds(new Rectangle(new Point(290, 125), button7.getPreferredSize()));

            //---- button8 ----
            button8.setText("\u53cc\u4eba\u95f4");
            button8.addActionListener(e -> button8());
            panel2.add(button8);
            button8.setBounds(new Rectangle(new Point(165, 25), button8.getPreferredSize()));

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
    private JLabel label4;
    private JPanel panel1;
    private JButton button2;
    private JPanel panel2;
    private JButton button1;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
