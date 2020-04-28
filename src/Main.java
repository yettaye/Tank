import com.yetta.tank.TankFrame;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
      TankFrame tf = new TankFrame();
      while(true){
          TimeUnit.MILLISECONDS.sleep(50);
          tf.repaint();
      }
    }
}
