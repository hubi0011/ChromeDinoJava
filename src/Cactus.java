import java.awt.*;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy {
    private BufferedImage image;
    private int posX,posY;
    MainCharacter mainCharacter;
    private final Rectangle rectangle;
    private boolean isScoreGot =false;

    public Cactus(MainCharacter mainCharacter) {
        image= Resource.getResourceImage("src/Images/Cactus-1.png");
        posX=200;
        posY=65;
        rectangle=new Rectangle();
        this.mainCharacter=new MainCharacter();
    }
    public void update(){
        posX-=2;
        rectangle.x=posX;
        rectangle.y=posY;
        rectangle.width=image.getWidth();
        rectangle.height=image.getHeight();

    }
    @Override
    public Rectangle getBound(){
        return  rectangle;
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(image,posX,posY ,null);
    }
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public  boolean isOutOfScreen(){
        return  (posX+image.getWidth()<0);
    }

    @Override
    public boolean isOVer() {
        return  (mainCharacter.getX()>getPosX());
    }

    @Override
    public boolean isScoreGot() {
        return isScoreGot;
    }

    @Override
    public void setIsScoreGot(boolean isScoreGot) {
        this.isScoreGot=isScoreGot;
    }


}
