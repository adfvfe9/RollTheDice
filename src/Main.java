import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {
    static final int SCREENWIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    static final int SCREENHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    static CardLayout cl = new CardLayout();
    static JPanel screens = new JPanel(cl);
    static JFrame frame = new JFrame("Roll The Dice");
    static PlayerData currentPlayer = new PlayerData();
    static Random r = new Random();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.add(screens);

        screens.add(new GameScreen(), "game");
        screens.add(new ShopScreen(), "shop");
        screens.add(new NetScreen(), "net");

        cl.show(screens, "game");

        frame.setVisible(true);
    }
    public static void changeScreen(String name) {
        cl.show(screens, name);
    }
}
