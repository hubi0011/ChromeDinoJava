import java.awt.*;

public abstract class Enemy {
    public abstract Rectangle getBound();

    public abstract void draw(Graphics g);

    public abstract void update();

    public abstract boolean isOutOfScreen();

    public abstract boolean isOVer();

    public  abstract boolean  isScoreGot();

    public abstract void setIsScoreGot(boolean isScoreGot);

}
