import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShopScreen extends JPanel {
    JButton homeButton = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/homeButton.png")));
    JButton netButton = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/netButton.png")));
    JButton buyNewDiceButton = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/buyNewDiceButton.png")));

    public ShopScreen() {
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

        netButton.setBounds(1806, 65, 34, 45);
        netButton.setBorderPainted(false);
        netButton.setFocusPainted(false);;
        netButton.setContentAreaFilled(false);
        netButton.addActionListener(e -> {
            Main.changeScreen("net");
        });
        this.add(netButton);

        buyNewDiceButton.setBounds(609, 441, 686, 241);
        buyNewDiceButton.setBorderPainted(false);
        buyNewDiceButton.setFocusPainted(false);;
        buyNewDiceButton.setContentAreaFilled(false);
        buyNewDiceButton.addActionListener(e -> {

        });
        this.add(buyNewDiceButton);
    }
}
