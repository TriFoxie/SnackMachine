import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for SnackBar and main.
 *
 * @author  B
 * @version 0.0.1
 */
public class SnackBarTest
{
    /**
     * Default constructor for test class SnackBarTest
     */
    
    public SnackBarTest()
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
    public void WordArgs()
    {
        boolean pass = false;
        //This should throw an error as "cookie" isn't a valid input.
        try {
            SnackBar.main(new String[] {"cookie"});   
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        assert pass;
    }

    @Test
    public void EmptyArgs()
    {
        SnackBar.main(new String[0]);
    }

    @Test
    public void NormalArgs()
    {
        SnackBar.main(new String[] {"10","10","10","2"});
    }
    
    @Test
    public void ExtraArgs()
    {
        boolean pass = false;
        try {
            SnackBar.main(new String[] {"cookie"});   
        } catch (IllegalArgumentException e) {
            pass = true;
        }
        assert pass;
    }
    
    @Test
    public void ZeroArgs()
    {
        SnackBar.main(new String[] {"0","0","0","0"});
    }
    
    @Test
    public void NegativeArgs()
    {
        //Test every combination of negatives as they caused issues before
        SnackBar.main(new String[] {"-1","0","0","0"});
        SnackBar.main(new String[] {"0","-1","0","0"});
        SnackBar.main(new String[] {"0","0","-1","0"});
        SnackBar.main(new String[] {"0","0","0","-1"});
        SnackBar.main(new String[] {"-1","-1","0","0"});
        SnackBar.main(new String[] {"-1","0","-1","0"});
        SnackBar.main(new String[] {"-1","0","0","-1"});
        SnackBar.main(new String[] {"0","-1","-1","0"});
        SnackBar.main(new String[] {"0","-1","0","-1"});
        SnackBar.main(new String[] {"0","0","-1","-1"});
    }
}





