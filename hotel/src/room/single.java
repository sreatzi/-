/*
 * Created by JFormDesigner on Tue Dec 12 20:37:47 CST 2023
 */

package room;

import java.awt.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class single extends JFrame {
    public single() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setTitle("\u5355\u4eba\u95f4");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label3 ----
            label3.setText("\u65e0wifi");
            panel1.add(label3);

            //---- label4 ----
            label4.setText("\u6709\u7a7a\u8c03");
            panel1.add(label4);

            //---- label5 ----
            label5.setText("\u5c0f\u5c3a\u5bf8\u623f\u95f4");
            panel1.add(label5);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //---- label6 ----
        label6.setIcon(new ImageIcon(getClass().getResource("/res/images/hotel/1473578773968.jpg")));
        contentPane.add(label6, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
