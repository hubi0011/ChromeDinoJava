import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class EnemiesManager {
    private final BufferedImage cactus1;
    private final BufferedImage cactus2;
    private final ArrayList<Enemy> enemies;
    Cactus cactus;
    Random random;
    private final MainCharacter mainCharacter;
    private final GameScreen gameScreen;
    public EnemiesManager(MainCharacter mainCharacter, GameScreen gameScreen) {
        this.gameScreen=gameScreen;
        this.mainCharacter=mainCharacter;
        enemies=new ArrayList<>();
        cactus1= Resource.getResourceImage("src/Images/Cactus-1.png");
        cactus2=Resource.getResourceImage("src/Images/Cactus-3.png");
        random=new Random();
        enemies.add(getRandom());
    }


    public void update(){
        for (Enemy enemy : enemies) {
            enemy.update();
            if (enemy.isOVer() && !enemy.isScoreGot()) {
                gameScreen.plusScore(20);
                enemy.setIsScoreGot(true);
            }
            if (enemy.getBound().intersects(mainCharacter.getBound())){
                mainCharacter.setAlive(false);
            }
        }
        Enemy firtstEnemy=enemies.get(0);
        if (firtstEnemy.isOutOfScreen()){
            enemies.remove(firtstEnemy);
            enemies.add(getRandom());
        }

    }
    public  void reset(){
        enemies.clear();
        enemies.add(getRandom());
    }
    public void draw(Graphics g ){
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }
    private Cactus getRandom(){
        Cactus cactus=new Cactus(mainCharacter);
        cactus.setPosX(800);
        if (random.nextBoolean()){
            cactus.setImage(cactus1);
        }else
            cactus.setImage(cactus2);

        return cactus;
    }

}
