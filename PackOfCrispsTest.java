

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PackOfCrispsTest.
 *
 * @author  B
 * @version 0.0.1
 */
public class PackOfCrispsTest
{
    /**
     * Default constructor for test class PackOfCrispsTest
     */
    public PackOfCrispsTest()
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
    public void States()
    {
        PackOfCrisps packOfCr1 = new PackOfCrisps("test");
        assertEquals(true, packOfCr1.isClosed());
        assertEquals(false, packOfCr1.isEmpty());
        assertEquals("test", packOfCr1.getFlavour());
        packOfCr1.eatCrisp();
        packOfCr1.open();
        assertEquals(false, packOfCr1.isClosed());
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        packOfCr1.eatCrisp();
        assertEquals(true, packOfCr1.isEmpty());
        packOfCr1.eatCrisp();
        //Extra eatCrisp()'s to ensure no errors occur.
    }
}
