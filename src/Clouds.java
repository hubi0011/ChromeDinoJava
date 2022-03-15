

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Clouds {
    private final BufferedImage cloudImage;
    private final ArrayList<Cloud> cloudsList;

    public Clouds() {
        cloudImage = Resource.getResourceImage("src/Images/cloud.png");

        cloudsList =new ArrayList<Cloud>();

        Cloud cloud= new Cloud();
        cloud.posX=100;
        cloud.posY=50;
        cloudsList.add(cloud);

        cloud= new Cloud();
        cloud.posX=450;
        cloud.posY=15;
        cloudsList.add(cloud);

        cloud= new Cloud();
        cloud.posX=600;
        cloud.posY=25;
        cloudsList.add(cloud);
    }
    public void update(){
        for (Cloud clouds : cloudsList) {
            clouds.posX-=2;
        }
        Cloud firstCloud=cloudsList.get(0);
        if (firstCloud.posX+cloudImage.getWidth()<0){
            firstCloud.posX=600;
            cloudsList.remove(firstCloud);
            cloudsList.add(firstCloud);


        }
    }
    public  void draw(Graphics g){
        for (Cloud cloud : cloudsList) {
            g.drawImage(cloudImage, (int)cloud.posX, (int)cloud.posY, null);
        }
    }
    private static class Cloud{
        float posX;
        float posY;
    }
}
