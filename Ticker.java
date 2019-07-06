import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class vsd here.
 *
 * @author Nicolas Lisgaras
 * @version 22.06.19
 */

public class Ticker
{
    View v;

    TimerTask task;
    Timer timer;

    int deltaTime;
    int tick;

    /**
     * Ticker( view, delta time )
     */
    Ticker(View nV, int ndt){
        v = nV;
        tick = 0;
        deltaTime = ndt;
        task = new TimerTask() {
            public void run() {
                nV.update();
                //System.out.println(tick);
                tick++;
            }
        };

        timer = new Timer("Timer@"+v.getClass());
        timer.scheduleAtFixedRate(task, ndt, ndt); // task, first frame, tick delta
    }

    public int getTick(){
        return tick;
    }
}