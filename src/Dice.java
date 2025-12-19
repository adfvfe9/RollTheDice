import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dice extends JLabel {
    Face f1, f2, f3, f4, f5, f6;
    public Dice(Face faces[]) {
        if (faces.length != 6) {
            JOptionPane.showMessageDialog(null, "주사위 생성자 상태 꼬라지;", "ErrorCode1", JOptionPane.ERROR);
        } else {
            this.f1 = faces[0];
            this.f2 = faces[1];
            this.f3 = faces[2];
            this.f4 = faces[3];
            this.f5 = faces[4];
            this.f6 = faces[5];
        }
        this.setBounds(Main.SCREENWIDTH / 2 - 104, Main.SCREENHEIGHT / 2 - 104, 208, 208);
        this.setIcon(new ImageIcon(Dice.class.getResource("/images/Dice.png")));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Face curF = roll();
                setIcon(new ImageIcon(Dice.class.getResource("/images/Dice" + curF.getName() + ".png")));
                Main.currentPlayer.eyes += curF.getEyes();
                GameScreen.score.setText(String.valueOf(Main.currentPlayer.eyes));
                repaint();
            }
        });
    }
    Face roll() {
        switch (Main.r.nextInt(6)) {
            case 0 : {
                return f1;
            }
            case 1 : {
                return f2;
            }
            case 2 : {
                return f3;
            }
            case 3 : {
                return f4;
            }
            case 4 : {
                return f5;
            }
            case 5 : {
                return f6;
            }
            default : {
                return null;
            }
        }
    }
}
