/*
 * Created by JFormDesigner on Tue Dec 12 10:45:03 CST 2023
 */

package main;

import jfram.bookhotel;
import jfram.checkroom;
import jfram.needserve;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class userMain extends JFrame {
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        userMain frame = new userMain();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public userMain() {
        initComponents();
        thisComponentResized();
    }

    public void thisComponentResized() {
        // TODO add your code here
        int width = desktopPane.getWidth();
        int height = desktopPane.getHeight();

        if (width != 0 && height != 0) {
            backLabel.setBounds(0, 0, width, height);
            ImageIcon icon = new ImageIcon(getClass().getResource("/res/images/hotel/x2.png"));
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            backLabel.setIcon(new ImageIcon(img));
            backLabel.setBounds(0, 0, width, height);
        }
    }
    private void need(ActionEvent e) {
        // TODO add your code here

        System.out.println("触发我了");
        needserve frame = new needserve();
        frame.setBounds(0,0,280,280);
        desktopPane.add(frame, JLayeredPane.MODAL_LAYER);
    }

    private void roomtype(ActionEvent e) {
        // TODO add your code here
        checkroom frame = new checkroom();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame, JLayeredPane.MODAL_LAYER);
    }

    private void bookroom(ActionEvent e) {
        // TODO add your code here
        bookhotel frame = new bookhotel();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame, JLayeredPane.MODAL_LAYER);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem1 = new JMenuItem();
        desktopPane = new JDesktopPane();
        backLabel = new JLabel();

        //======== this ========
        setTitle("\u9152\u5e97\u5ba2\u6237\u9875\u9762");
        setIconImage(new ImageIcon(getClass().getResource("/res/images/hotel/x2.png")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- menuItem2 ----
            menuItem2.setText("\u989d\u5916\u9700\u6c42");
            menuItem2.addActionListener(e -> need(e));
            menuBar1.add(menuItem2);

            //---- menuItem3 ----
            menuItem3.setText("\u67e5\u770b\u623f\u578b");
            menuItem3.addActionListener(e -> roomtype(e));
            menuBar1.add(menuItem3);

            //---- menuItem1 ----
            menuItem1.setText("\u9884\u8ba2\u623f\u95f4");
            menuItem1.addActionListener(e -> bookroom(e));
            menuBar1.add(menuItem1);
        }
        setJMenuBar(menuBar1);

        //======== desktopPane ========
        {

            //---- backLabel ----
            backLabel.setIcon(new ImageIcon(getClass().getResource("/res/images/hotel/index.jpg")));
            desktopPane.add(backLabel, JLayeredPane.DEFAULT_LAYER);
            backLabel.setBounds(0, 5, 615, backLabel.getPreferredSize().height);
        }
        contentPane.add(desktopPane, BorderLayout.CENTER);
        setSize(620, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem1;
    private JDesktopPane desktopPane;
    private JLabel backLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
