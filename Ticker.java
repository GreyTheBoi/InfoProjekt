
/**
 * Write a description of class vsd here.
 *
 * @author Nicolas Lisgaras
 * @version 22.06.19
 */

public class Ticker
{
    View v;
    
    int deltaTime;
    long t0, t1;
    int t = 0;
    
    /**
     * Ticker( view, delta time )
     */
    Ticker(View nV, int ndt){
        v = nV;
        deltaTime = ndt;
    }
    
    /**
     * 
     */
    public void tick()
    {
        while(true)
        {
            t0 = System.currentTimeMillis(); //update absolute
            do
            {
                t1 = System.currentTimeMillis(); //update delta
            }
            while (t1 - t0 < deltaTime); //compare delta
            
            //ticker events 
            t += 1;
            System.out.println("tick " + deltaTime/1000 + "s");
            v.update();
        }
    }
}