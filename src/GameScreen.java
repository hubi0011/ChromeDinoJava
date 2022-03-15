import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class GameScreen extends JPanel implements Runnable , KeyListener {
    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 110;

    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    private int gameState = GAME_FIRST_STATE;
    private int score=0;
    Thread thread;

    private AudioClip scroreUp;

    private final MainCharacter mainCharacter;
    private final Land land;
    private float speedX;
    private final Clouds cloud;
    private final EnemiesManager enemiesManager;

    BufferedImage imageGameOver;
    BufferedImage imageIntro;
    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50);
        mainCharacter.setY(60);
        land = new Land(this);
        cloud = new Clouds();
        enemiesManager = new EnemiesManager(mainCharacter,this);
        imageGameOver= Resource.getResourceImage("src/Images/game-over.png");
        imageIntro=Resource.getResourceImage("src/Images/intro-text.png");

    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
//            System.out.println(i++);
            try {
                update();
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {

        if (gameState == GAME_PLAY_STATE) {
            cloud.update();
            mainCharacter.update();
            land.update();
            enemiesManager.update();
            if (!mainCharacter.isAlive()) {
                gameState = GAME_OVER_STATE;

            }
        }

    }
    public  void resetGame(){
        mainCharacter.setAlive(true);
        mainCharacter.setX(50);
        mainCharacter.setY(60);
        enemiesManager.reset();
    }
    public void plusScore(int score){
        this.score+=score;
    }

    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, 0, getWidth(), getHeight());
        switch (gameState) {
            case GAME_FIRST_STATE:
                g.drawImage(imageIntro,100,50,null);
                break;
            case GAME_PLAY_STATE:
                cloud.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                g.drawString("HI:"+ score,750,20);
                break;
            case GAME_OVER_STATE:
                cloud.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                g.drawImage(imageGameOver,100,50,null);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameState == GAME_FIRST_STATE) {
                gameState = GAME_PLAY_STATE;
            } else if (gameState == GAME_PLAY_STATE) {
                mainCharacter.jump();
            } else if (gameState == GAME_OVER_STATE) {
                resetGame();
                gameState = GAME_PLAY_STATE;
            }
        }
    }
}
