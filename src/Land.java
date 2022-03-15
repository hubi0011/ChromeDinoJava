import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Land {

    private final BufferedImage ground;
    private final ArrayList<ImageLand> listImage;

    public Land(GameScreen gameScreen) {
        ground= Resource.getResourceImage("src/Images/Ground.png");

        listImage=new ArrayList<>();
        int numberofLand=600/ground.getWidth()+2;

        for (int i = 0; i < numberofLand; i++) {

            ImageLand imageLand=new ImageLand();
            imageLand.posX=(i*ground.getWidth());
            imageLand.image=ground;
            listImage.add(imageLand);
        }
    }



    public void update(){
        for (ImageLand imageLand : listImage) {
            imageLand.posX--;
        }
//
        ImageLand firstElement=listImage.get(0);
        if (firstElement.posX+ground.getWidth() <0){
            firstElement.posX=listImage.get(listImage.size()-1).posX+ground.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }

    }

    public void draw(Graphics g) {
        for (ImageLand imageLand : listImage) {
            g.drawImage(imageLand.image, imageLand.posX, (int) GameScreen.GROUNDY - 12, null);

        }
    }

        private class ImageLand{
        int posX;
        BufferedImage image;
    }
}
