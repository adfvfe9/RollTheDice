import javax.swing.*;
import java.awt.*;

public class RotateLabel extends JLabel {
    private double angle;
    private boolean flip;
    private boolean isHovered;

    public RotateLabel(ImageIcon image) {
        super(image);
        this.angle = 0;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setBounds(int x, int y, int width, int height, boolean b) {
        if (b) {
            int newWH = (int)Math.sqrt(width * width + height * height) + 1;
            super.setBounds(x, y, newWH, newWH);
        } else {
            super.setBounds(x, y, width, height);
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        int rotateCenterX = this.getWidth() / 2;
        int rotateCenterY = this.getHeight() / 2;

        gd.translate(rotateCenterX, rotateCenterY);

        if (flip) {
            gd.scale(-1, 1);
        }

        gd.rotate(Math.toRadians(this.angle));
        gd.translate(-rotateCenterX, -rotateCenterY);

        super.paintComponent(gd);
        gd.dispose();
    }

    public void lookPointer(Point p) {
        int wid = Main.SCREENWIDTH;
        this.flip = p.x - wid / 2 < 0;
        this.setAngle(Math.toDegrees(-Math.atan2(
            (p.x - wid / 2 < 0) ? (p.x - (double)wid / 2) : -(p.x - (double)wid / 2),
            -(p.y - (double)Main.SCREENHEIGHT / 2))) - 75 - Math.sqrt(Math.hypot(
            p.x - (double)wid / 2, -(p.x - (double)wid / 2)) / 10));
        repaint();
    }
}