import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
    private final ArrayList<BufferedImage> frames;
    private int frameIndex=0;
    private final int deltaTime;
    private long previousTime;

    public Animation(int deltaTime) {
        this.frames = new ArrayList<BufferedImage>();
        this.deltaTime=deltaTime;
    }
    public void update(){
        if (System.currentTimeMillis()-previousTime>deltaTime) {
            frameIndex++;
            if (frameIndex >= frames.size()) {
                frameIndex = 0;
            }
            previousTime=System.currentTimeMillis();
        }
    }
    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }

    public BufferedImage getFrame(){
        if (frames.size()>0){
            return frames.get(frameIndex);
        }
        return null;
    }

}
