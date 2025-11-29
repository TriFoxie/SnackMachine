

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SnackMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SnackMachineTest
{
    /**
     * Default constructor for test class SnackMachineTest
     */
    public SnackMachineTest()
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
    public void BuyPack()
    {
        SnackMachine snackMac1 = new SnackMachine(10, 2);
        assertEquals(2, snackMac1.getCost());
        snackMac1.addPack(new PackOfCrisps("test"));
        assertEquals(1, snackMac1.countPacks("test"));
        assertNull(snackMac1.buyPack("test"));
        snackMac1.insertMoney(new Penny());
        snackMac1.insertMoney(new Penny());
        assertNotNull(snackMac1.buyPack("test"));
        assertNull(snackMac1.buyPack("test"));
    }
}
