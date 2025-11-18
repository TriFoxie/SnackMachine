/**
 * Simulates a packet of crisps.
 * Starts with 10 crisps.
 * Can either be open or closed.
 * Crisps can only be eaten when it is open.
 * 
 * @author B
 * @version v0.0.1
 */
public class PackOfCrisps
{
    private boolean open;
    private int numOfCrisps;
    private String flavour;
    
    /**
     * Constructs a new packet of crisps with the specified flavour.
     * Initially contains 10 crisps.
     * 
     * @param   flavour the flavour of the crisps.
    */
    public PackOfCrisps(String flavour) {
        this.flavour = flavour;
        numOfCrisps = 10;
        open = false;
    }
    
    /**
     * Gets whether the number of crisps is greater than 0.
     * @return  Whether the crisp packet is empty or not.
     */
    public boolean isEmpty() {
        if (numOfCrisps == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Gets whether the pack is closed.
     * @return Whether the crisp packet is closed or not.
     */
    public boolean isClosed() {
        return !open;
    }
    
    /**
     * Opens the crisp packet by setting open to true.
     */
    public void open() {
        open = true;
    }
    
    /**
     * Gets the flavour of the crisps.
     * @return The flavour of the crisps.
     */
    public String getFlavour() {
        return flavour;
    }
    
    /**
     * Simulates eating a crisp by incrementing the amount of crisps in the packet by -1.
     * Fails and outputs the corresponding error if either the pack is empty or not yet open.
     */
    public void eatCrisp() {
        if (open) {
            if (numOfCrisps > 0) {
                numOfCrisps -= 1;   
            } else {
                System.out.println("The packet is empty!");   
            }
        } else {
            System.out.println("Need to open the packet first!");
        }
    }
}