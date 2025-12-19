import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameScreen extends JPanel {
    static JLabel score = new JLabel(String.valueOf(Main.currentPlayer.eyes));
    public GameScreen() {
        this.setLayout(null);
        this.setFocusable(true);

        score.setBounds(100, 100, 1000, 100);
        score.setFont(new Font("Aleo", Font.BOLD, 40));
        score.setText("0");
        this.add(score);

        Dice d = new Dice(new Face[]{
            new Face(1), new Face(2), new Face(3), new Face(4), new Face(5), new Face(6)
        });
        this.add(d);
    }
}
