import java.util.ArrayList;
/**
 * Representation of an automated vending machine.
 * Works with crisp packets.
 *
 * @author B
 * @version 0.0.1
 */

public class SnackMachine
{
    private ArrayList<Penny> pennies;
    private ArrayList<PackOfCrisps> packets;
    private int capacity;
    private int cost;
    private int payment;
    
    /**
     * Constructs a new snack machine with specified capacity and cost.
     * 
     * @param   capacity    the maximum amount of crisp packets the machine can hold at any time.
     * @param   cost        the cost of each individual packet.
     */
    public SnackMachine(int capacity, int cost) {
        this.capacity = capacity;
        this.cost = cost;
        pennies = new ArrayList<Penny>();
        packets = new ArrayList<PackOfCrisps>();
        payment = 0;
    }
    
    /**
     * Gets the cost of a packet from the machine.
     * 
     * @return  The cost of 1 packet.
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Adds a packet to the machine.
     * 
     * @param   pack    the packet to be added to the machine.
     */
    public void addPack(PackOfCrisps pack) {
        if (packets.size() >= capacity) {
            System.out.println("The machine is already full.");
        } else {
            packets.add(pack);
        }
    }
    
    /**
     * Gets the amount of packs of a specified flavour that are in the machine.
     * 
     * @param   flavour the flavour to look for.
     * @return  The amount of packs of that flavour that were found.
     */
    public int countPacks(String flavour) {
        int packs = 0;
        for (PackOfCrisps pack: packets) {
            if (pack.getFlavour().equals(flavour)) {
                packs += 1;
            }
        }
        return packs;
    }
    
    /**
     * Inserts a penny into the machine
     * 
     * @param   Penny object to be inserted.
     */
    public void insertMoney(Penny penny) {
        pennies.add(penny);
        payment += 1;
    }
    
    /**
     * Attempts to purchase a pack of the specified flavour.
     * Fails if: there was insufficient payment or
     * there aren't any packs of the specified flavour.
     * 
     * @param   flavour the flavour you wish to buy.
     * @return          the purchased pack if it is successful, otherwise null.
     */
    public PackOfCrisps buyPack(String flavour) {
        if (this.countPacks(flavour) >= 1) {
            if (payment >= cost) {
                payment = 0;
                for (int i = 0; i < packets.size(); i++) {
                    if (packets.get(i).getFlavour() == flavour) {
                        return packets.remove(i);
                    }
                }//Use loop instead of .remove() as this way it can get the the actual object allowing for preservation of more information than just flavour if needed.
            } else {
                System.out.println("Not enough money. You need: " + cost + " pennies");
            }
        } else {
            System.out.println("No " + flavour + " packs left.");
        }
        return null;
    }
    
    /**
     * Outputs the current state of the machine expressed as a string.
     * E.g: "The snack machine has 15 packets of crisps left and has taken 12
     * pennies in payment.
     */
    public void describe() {
        System.out.println("The snack machine has " + packets.size() +
        " packets of crisps left and has taken " + pennies.size() + 
        " pennies in payment.");
    }
}