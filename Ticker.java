
/**
 * Write a description of class vsd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Ticker
{
    public int time = 0;
    long t0, t1;
    
    public void tick()
    {
        while(true)
        {
            t0 = System.currentTimeMillis();
            do
            {
                t1 = System.currentTimeMillis();
            }
            while (t1 - t0 < 5000);
            time = time + 1;
            System.out.println("tick 5s");
        }
    }
}