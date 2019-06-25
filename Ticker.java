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
    long t0, t1;
    int t = 0;
    public boolean running;

    /**
     *  changes view to keep smae ticker for all views and to have no nullpointers
     */
    public void setReference(View nV)
    {
        v = nV;
    }

    public void terminate()
    {
        running = false;
        System.out.println("terminated");
    }

    /**
     * Ticker( view, delta time )
     */
    Ticker(View nV, int ndt){
        v = nV;
        deltaTime = ndt;
        task = new TimerTask() {
            public void run() {
                nV.update();
            }
        };

        timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, ndt, ndt); // task, first frame, tick delta
    }

    /**
     * Ticker( view, delta time )
     */
    Ticker(View nV, int ndt, boolean debug){
        v = nV;
        deltaTime = ndt;
        task = new TimerTask() {
            public void run() {
                if(debug == true) System.out.println("Task performed on: " + "Ref instance:" + nV.getClass() + "\nThread's name: " + Thread.currentThread().getName() + "\ntick delta: " + ndt + "\n");
                nV.update();
            }
        };

        timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, ndt, ndt); // task, first frame, tick delta
    }

}