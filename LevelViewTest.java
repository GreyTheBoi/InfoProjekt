

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LevelViewTest.
 *
 * @author  Nicolas Lisgaras
 * @version 25.06.19
 */
public class LevelViewTest
{
    /**
     * Default constructor for test class LevelViewTest
     */
    public LevelViewTest()
    {
    }
    
    @Test
    public void getDefaultInputValueProperly() {
        View levelView = new LevelView();
        
        assertEquals("gets first frame input as N/A", "N/A", levelView.getWindowInput());
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
