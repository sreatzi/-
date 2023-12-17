/*
 * Created by JFormDesigner on Mon Dec 11 22:02:54 CST 2023
 */

package main;

import jfram.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 86151
 */
public class Main extends JFrame {
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

        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public Main() {
        initComponents();
    }

    private void thisComponentResized(ComponentEvent e) {
        // TODO add your code here
        int width = desktopPane.getWidth();
        int height = desktopPane.getHeight();

        if (width != 0 && height != 0) {
            backLabel.setBounds(0, 0, width, height);
            ImageIcon icon = new ImageIcon(getClass().getResource("/res/images/1473578777426.jpeg"));
            icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            backLabel.setIcon(icon);
            backLabel.setOpaque(true);
        }

    }

    private void roomfloat(ActionEvent e) {
        // TODO add your code here
        louceng frame = new louceng();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame, JLayeredPane.MODAL_LAYER);
    }

    private void roomtype(ActionEvent e) {
        // TODO add your code here
        roomtype frame = new roomtype();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void roomstats(ActionEvent e) {
        // TODO add your code here
        roomstats frame = new roomstats();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void allpay(ActionEvent e) {
        // TODO add your code here
        serveall frame = new serveall();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void servepay(ActionEvent e) {
        // TODO add your code here
        servepay frame = new servepay();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void servetype(ActionEvent e) {
        // TODO add your code here
        servetype frame = new servetype();
        frame.setBounds(0,0,400,300);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void payrecoding(ActionEvent e) {
        // TODO add your code here
        payrecoding frame = new payrecoding();
        frame.setBounds(0,0,500,400);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void menuItem1() {
        // TODO add your code here
        louceng frame = new louceng();
        frame.setBounds(0,0,500,400);
        desktopPane.add(frame, JLayeredPane.MODAL_LAYER);

    }

    private void menuItem2() {
        // TODO add your code here
        serveall frame = new serveall();
        frame.setBounds(0,0,500,400);
        desktopPane.add(frame,JLayeredPane.MODAL_LAYER);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem7 = new JMenuItem();
        desktopPane = new JDesktopPane();
        backLabel = new JLabel();

        //======== this ========
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf-\u7ba1\u7406\u5458");
        setIconImage(new ImageIcon(getClass().getResource("/res/images/hotel/x3.png")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- menuItem1 ----
            menuItem1.setText("\u9152\u5e97\u5ba2\u623f");
            menuItem1.addActionListener(e -> menuItem1());
            menuBar1.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("\u9152\u5e97\u670d\u52a1");
            menuItem2.addActionListener(e -> menuItem2());
            menuBar1.add(menuItem2);

            //---- menuItem7 ----
            menuItem7.setText("\u6d88\u8d39\u8bb0\u5f55");
            menuItem7.addActionListener(e -> payrecoding(e));
            menuBar1.add(menuItem7);
        }
        setJMenuBar(menuBar1);

        //======== desktopPane ========
        {

            //---- backLabel ----
            backLabel.setIcon(new ImageIcon(getClass().getResource("/res/images/1473578777426.jpeg")));
            desktopPane.add(backLabel, JLayeredPane.DEFAULT_LAYER);
            backLabel.setBounds(0, 0, 680, 460);
        }
        contentPane.add(desktopPane, BorderLayout.CENTER);
        setSize(685, 525);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem7;
    private JDesktopPane desktopPane;
    private JLabel backLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
