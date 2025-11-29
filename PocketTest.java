

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PocketTest.
 *
 * @author  B
 * @version 0.1
 */
public class PocketTest
{
    /**
     * Default constructor for test class PocketTest
     */
    public PocketTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void Creation()
    {
        Pocket pocket1 = new Pocket(20);
        assertEquals(20, pocket1.pennyCount());
    }

    @Test
    public void RemovePenny()
    {
        Pocket pocket1 = new Pocket(20);
        pocket1.removePenny();
        assertEquals(19, pocket1.pennyCount());
        pocket1.removePenny();
        assertEquals(18, pocket1.pennyCount());
        Pocket pocket2 = new Pocket(0);
        assertEquals(null, pocket2.removePenny());
        assertEquals(0, pocket2.pennyCount());
    }
}

