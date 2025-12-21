import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShopScreen extends JPanel {
    JButton homeButton = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/homeButton.png")));
    JButton netButton = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/netButton.png")));
    JButton buyNewDiceButtonLabel = new JButton(new ImageIcon(ShopScreen.class.getResource("/images/buyNewDiceButtonLabel.png")));
    JLabel buyNewDicePrice = new JLabel("0");

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

        buyNewDiceButtonLabel.setBounds(762, 343, 400, 500);
        buyNewDiceButtonLabel.setBorderPainted(false);
        buyNewDiceButtonLabel.setFocusPainted(false);;
        buyNewDiceButtonLabel.setContentAreaFilled(false);
        buyNewDiceButtonLabel.addActionListener(e -> {
            //TODO 이거내용채우기...
        });
        this.add(buyNewDiceButtonLabel);

        buyNewDicePrice.setBounds(825, 745, 300, 75);
        buyNewDicePrice.setFont(new Font("Aleo", Font.BOLD, 50));
        buyNewDicePrice.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(buyNewDicePrice);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                buyNewDicePrice.setText(String.valueOf((int)Math.pow(500, GameScreen.dices.size())));
            }
        });
    }
}
