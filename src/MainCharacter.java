import java.awt.*;

public class MainCharacter {
    private float x=0;
    private float y=0;
    private float speedY=0;
    public static final float GROUNDY= GameScreen.GROUNDY;
    private final Animation characterRun;
    private final Rectangle rectangle;
    private boolean isAlive=true;
    public MainCharacter() {
        characterRun=new Animation(250);
        characterRun.addFrame(Resource.getResourceImage("src/Images/Dino-left-up.png"));
        characterRun.addFrame(Resource.getResourceImage("src/Images/Dino-right-up.png"));
        rectangle=new Rectangle();
    }

    public void update(){
        characterRun.update();
        if (y>= GROUNDY-characterRun.getFrame().getHeight()) {
            speedY=0;
            y= GROUNDY-characterRun.getFrame().getHeight();
        }else{
            speedY+= GameScreen.GRAVITY;
            y+=speedY;
        }
        rectangle.x=(int )x;
        rectangle.y=(int)y;
        rectangle.height=characterRun.getFrame().getHeight();
        rectangle.width=characterRun.getFrame().getHeight();
    }

    public Rectangle getBound(){
        return rectangle;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawImage(characterRun.getFrame(),(int)x,(int)y,null);
    }
    public void jump(){
        speedY=-4;
        y+=speedY;

    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
