import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
public class Orange extends Bomb {
    Image img;
    public int count = 0;
    Orange() {
        String imageLocation = "Orange.png";
        URL imageURL1 = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
    }

    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                y += 2;
                if (y >= 1100) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(80);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    public Image getImage() {
        return img;
    }

}