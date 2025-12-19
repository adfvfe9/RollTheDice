import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NetScreen extends JPanel {
    static int curPage = 0;

    JButton homeButton = new JButton(new ImageIcon(NetScreen.class.getResource("/images/homeButton.png")));
    JButton leftPageButton = new JButton(new ImageIcon(NetScreen.class.getResource("/images/leftPageButton.png")));
    JButton rightPageButton = new JButton(new ImageIcon(NetScreen.class.getResource("/images/rightPageButton.png")));
    JButton leftPageDisButton = new JButton(new ImageIcon(NetScreen.class.getResource("/images/leftPageDisButton.png")));
    JButton rightPageDisButton = new JButton(new ImageIcon(NetScreen.class.getResource("/images/rightPageDisButton.png")));

    public NetScreen() {
        this.setLayout(null);
        this.setFocusable(true);

        homeButton.setBounds(60, 60, 60, 60);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.addActionListener(e -> {
            Main.changeScreen("game");
        });
        this.add(homeButton);

        leftPageButton.setBounds(30, 490, 100, 100);
        leftPageButton.setBorderPainted(false);
        leftPageButton.setFocusPainted(false);
        leftPageButton.setContentAreaFilled(false);
        leftPageButton.setVisible(false);
        leftPageButton.addActionListener(e -> {
            goLeftPage();
        });
        this.add(leftPageButton);

        rightPageButton.setBounds(1790, 490, 100, 100);
        rightPageButton.setBorderPainted(false);
        rightPageButton.setFocusPainted(false);
        rightPageButton.setContentAreaFilled(false);
        rightPageButton.setVisible(false);
        rightPageButton.addActionListener(e -> {
            goRightPage();
        });
        this.add(rightPageButton);

        leftPageDisButton.setBounds(30, 490, 100, 100);
        leftPageDisButton.setBorderPainted(false);
        leftPageDisButton.setFocusPainted(false);
        leftPageDisButton.setContentAreaFilled(false);
        leftPageDisButton.setVisible(false);
        this.add(leftPageDisButton);

        rightPageDisButton.setBounds(1790, 490, 100, 100);
        rightPageDisButton.setBorderPainted(false);
        rightPageDisButton.setFocusPainted(false);
        rightPageDisButton.setContentAreaFilled(false);
        rightPageDisButton.setVisible(false);
        this.add(rightPageDisButton);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                goLeftPage();
                goRightPage();
            }
        });
    }

    void goLeftPage() {
        if (curPage == 0) {
            leftPageDisButton.setVisible(true);
            leftPageButton.setVisible(false);
        } else {
            leftPageDisButton.setVisible(false);
            leftPageButton.setVisible(true);
        }
    }

    void goRightPage() {
        if (curPage == GameScreen.dices.size() - 1) {
            rightPageDisButton.setVisible(true);
            rightPageButton.setVisible(false);
        } else {
            rightPageDisButton.setVisible(false);
            rightPageButton.setVisible(true);
        }
    }
}
