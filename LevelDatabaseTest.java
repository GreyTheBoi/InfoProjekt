import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LevelDatabaseTest.
 *
 * @author  Nicoals Lisgaras
 * @version 04.07.19
 */
public class LevelDatabaseTest
{
    LevelDatabase DB;
    /**
     * Default constructor for test class LevelDatabaseTest
     */
    public LevelDatabaseTest()
    {
        DB = new LevelDatabase();
    }

    /**
     * Testet ob datenbank Strings richtig lesen kann, dabei muss der eintrag mit ID -1 100 sein 
     */
    @Test
    public void getDBstringValueProperly() {        
        assertEquals("checks if selectString works", "err", DB.selectString("type",-1));
    }

    /**
     * Testet ob datenbank integer richtig lesen kann, dabei muss der eintrag mit ID -1 100 sein 
     */
    @Test
    public void getDBintValueProperly() {
        assertEquals("checks if selectString works", 1000, DB.selectInt("death",-1));
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
