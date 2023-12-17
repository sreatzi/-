/*
 * Created by JFormDesigner on Tue Dec 12 21:05:06 CST 2023
 */

package room;

import java.awt.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class loftroom extends JFrame {
    public loftroom() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u590d\u5f0f\u623f");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label1 ----
            label1.setText("\u6709wifi");
            panel1.add(label1);

            //---- label2 ----
            label2.setText("\u6709\u7a7a\u8c03");
            panel1.add(label2);

            //---- label3 ----
            label3.setText("\u8d85\u5927\u5c3a\u5bf8");
            panel1.add(label3);

            //---- label4 ----
            label4.setText("\u590d\u5f0f\u8bbe\u8ba1  \u5c3d\u60c5\u4eab\u53d7\u4e1d\u6ed1");
            panel1.add(label4);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //---- label5 ----
        label5.setIcon(new ImageIcon(getClass().getResource("/res/images/hotel/WiredPlus_2048x1536.jpg")));
        contentPane.add(label5, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
