import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dice extends JLabel {
    Face faces[] = new Face[6];
    public Dice(Face faces[]) {
        if (faces.length != 6) {
            JOptionPane.showMessageDialog(null, "주사위 생성자 상태 꼬라지;", "ErrorCode1", JOptionPane.ERROR);
        } else {
            for (int i = 0; i < this.faces.length; i++) {
                this.faces[i] = faces[i];
            }
        }
        this.setBounds(Main.SCREENWIDTH / 2 - 104, Main.SCREENHEIGHT / 2 - 104, 208, 208);
        this.setIcon(new ImageIcon(Dice.class.getResource("/images/Dice.png")));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Face curF = roll();
                setIcon(new ImageIcon(Dice.class.getResource("/images/Dice" + curF.getName() + ".png")));
                Main.currentPlayer.changeEyesVal(curF.getEyes());
                GameScreen.score.setText(String.valueOf(Main.currentPlayer.eyes));
                repaint();
            }
        });
    }

    Face roll() {
        return faces[Main.r.nextInt(6)];
    }

    JButton[] getButtons() {
        JButton[] buttons = new JButton[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(new ImageIcon(Dice.class.getResource("/images/Dice" + this.faces[i].getName() + ".png")));
            buttons[i].setBorderPainted(false);
            buttons[i].setFocusPainted(false);
            buttons[i].setContentAreaFilled(false);
            switch (i) {
                case 0 : {
                    buttons[i].setBounds(843, 74, 234, 234);
                    break;
                }
                case 1 : {
                    buttons[i].setBounds(610, 307, 234, 234);
                    break;
                }
                case 2 : {
                    buttons[i].setBounds(843, 307, 234, 234);
                    break;
                }
                case 3 : {
                    buttons[i].setBounds(843, 773, 234, 234);
                    break;
                }
                case 4 : {
                    buttons[i].setBounds(1076, 307, 234, 234);
                    break;
                }
                case 5 : {
                    buttons[i].setBounds(843, 540, 234, 234);
                    break;
                }
            }
        }
        return buttons;
    }
}
