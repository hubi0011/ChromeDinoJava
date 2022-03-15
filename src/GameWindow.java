import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private GameScreen gameScreen;

    public GameWindow(){
        setTitle("Chrome-Dino-Run");
        setSize(800,200);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() -getHeight()) / 2);
        setLocation(x, y);

        setLocation(400,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameScreen =new GameScreen();
        this.add(gameScreen);
        addKeyListener(gameScreen);

    }

    public void startGame(){
        gameScreen.startGame();
    }

    public static void main(String[] args) {
        GameWindow gameWindow=new GameWindow();
        gameWindow.setVisible(true);
        gameWindow.startGame();;
    }

}
