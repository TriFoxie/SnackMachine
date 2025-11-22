/**
 * Simulates a student that can take various actions.
 * Can do things such as eat and buy crisp packets.
 * 
 * @author B
 * @version
 */
public class Student
{
    private static int STUDENT_ID = 0;
    
    private String favouriteFlavour;
    private SnackMachine snackMachine;
    private String idNumber;
    private Pocket pocket;
    private PackOfCrisps packet;
    
    /**
     * Constructs a new Student with a specified favourite flavour.
     * 
     * @param flavour the student's favourite flavour (the crisps they will buy).
     * @param snackMachine a reference to a snackMachine object to buy crisps from.
     */
    public Student(String flavour, SnackMachine snackMachine) {
        STUDENT_ID += 1;
        favouriteFlavour = flavour;
        idNumber = "student" + STUDENT_ID;
        pocket = new Pocket(20);
        packet = null;
        this.snackMachine = snackMachine;
    }
    
    private void buyCrisps() {
        if (snackMachine.countPacks(favouriteFlavour) == 0) {
            System.out.println("The machine has run out of " + 
            idNumber + "'s favourite, " + 
            favouriteFlavour + 
            " crisps.");
        } else if (snackMachine.getCost() > pocket.pennyCount()) {
            System.out.println(idNumber + 
            " doesn't have enough money to buy a pack! They need " + 
            (snackMachine.getCost() - pocket.pennyCount()) + 
            " more pennies.");
        } else {
            for (int i = 0; i < snackMachine.getCost(); i++) {
                snackMachine.insertMoney(pocket.removePenny());
            }
            packet = snackMachine.buyPack(favouriteFlavour);
        }
    }
    
    /**
     * Completes an action based on what the student currently has.
     * Buys a pack if the student doesn't have one yet.
     * Opens a packet the student has one already that is closed.
     * If the student has an open packet already, it eats a crisp.
     * If the student's packet is empty, it is discarded.
     */
    public void snackTime() {
        if (packet == null) {
            System.out.println(idNumber + " is buying a pack of crisps.");
            buyCrisps();
        } else if (packet.isClosed()) {
            System.out.println(idNumber + " is opening their packet.");
            packet.open();
        } else if (packet.isEmpty()) {
            System.out.println(idNumber + " has finished the packet!");
            packet = null;
        } else {
            System.out.println(idNumber + " is eating a favourite " + favouriteFlavour + " crisp.");
            packet.eatCrisp();
        }
    }
}