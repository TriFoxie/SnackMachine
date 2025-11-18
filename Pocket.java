import java.util.HashSet;

/**
 * Simulates a pocket for containing pennies.
 * 
 * @author Marcus
 * @version v0.0.1
 */
public class Pocket
{
    private HashSet<Penny> pennies;
    
    /**
     * Creates a new pocket with amount of pennies specified.
     * 
     * @param   size    number of pennies the pocket should start with.
     */
    public Pocket(int size) {
        pennies = new HashSet<Penny>();
        
        for(int i = 0; i < size; i++) {
            pennies.add(new Penny());   
        }
    }
    
    /**
     * Returns the amount of pennies in the pocket currently.
     * 
     * @return  how many pennies are remaining (int).
     */
    public int pennyCount() {
        return pennies.size();
    }
    
    /**
     * Removes one penny from the pocket if there are any, returning that penny.
     * Null if there are no pennies left.
     * 
     * @return  new Penny(); null if none left in the pocket.
     */
    public Penny removePenny() {
        if (pennies.size() > 0) {
            pennies.remove(new Penny());
            return new Penny();
        } else {
            return null;
        }
    }
}