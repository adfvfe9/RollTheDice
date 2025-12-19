import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class GameScreen extends JPanel {
    static JLabel score = new JLabel(String.valueOf(Main.currentPlayer.eyes));
    static ArrayList<Dice> dices = new ArrayList<>();
    JButton shopButton = new JButton(new ImageIcon(GameScreen.class.getResource("/images/shopButton.png")));
    public GameScreen() {
        this.setLayout(null);
        this.setFocusable(true);

        score.setBounds(60, 70, 1000, 100);
        score.setFont(new Font("Gothic", Font.BOLD, 40));
        score.setText("0");
        this.add(score);

        Dice d = new Dice(new Face[]{
            new Face(1), new Face(2), new Face(3), new Face(4), new Face(5), new Face(6)
        });
        this.add(d);
        dices.add(d);

        shopButton.setBounds(60, 950, 60, 60);
        shopButton.setBorderPainted(false);
        shopButton.setFocusPainted(false);;
        shopButton.setContentAreaFilled(false);
        shopButton.addActionListener(e -> {
            Main.changeScreen("shop");
        });
        this.add(shopButton);
    }
}
