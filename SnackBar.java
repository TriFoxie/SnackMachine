import java.util.Random;
import java.util.ArrayList;

/**
 * Simulates students interacting with a snack bar and buying and consuming crisps.
 * 
 * @author B
 * @version 0.0.1
 */
public class SnackBar
{
    private Random rnd;
    private String[] flavours;
    private SnackMachine snackMachine;
    private ArrayList<Student> students;
    
    /**
     * Constructs a new snackbar with the specified number of students and packets and the cost.
     * 
     * @param numOfStudents the number of students in teh simulation.
     * @param numOfPackets the number of crisp packets available in the snack machine.
     * @param cost the cost of each individual pack of crisps.
     */
    public SnackBar(int numOfStudents, int numOfPackets, int cost) {
        rnd = new Random();
        flavours = new String[]{"salt and vinegar", "cookie dough", "sweetcorn"};
        snackMachine = new SnackMachine(numOfPackets, cost);
        students = new ArrayList<Student>();
        
        for (int i = 0; i < numOfPackets; i++) {
            snackMachine.addPack(new PackOfCrisps(randomFlavour()));
        }
        for (int i = 0; i < numOfStudents; i++) {
            students.add(new Student(randomFlavour(), snackMachine));
        }
    }
    
    private String randomFlavour() {
        return flavours[rnd.nextInt(flavours.length)];
    }
    
    /**
     * Describes the current state of the "simulation". <br><br>
     * Example output:<br><br>
     * The snack bar has:<br>
     *  | 200 hungry students...<br>
     * The snack machine has:<br>
     *  | 20 packets of salt and vinegar crisps...<br>
     *  | 34 packets of cookie dough crisps...<br>
     *  | 12 packets of sweetcorn crisps...<br>
     */
    public void describe() {
        String description = 
            "The snack bar has:\n" +
            " |" + students.size() + " hungry students...\n" +
            "The snack machine has:\n";
        
        for (String flavour: flavours) {
            description += " |" + snackMachine.countPacks(flavour) + " packets of " + flavour + " crisps...\n";
        }
        
        System.out.println(description);
    }
    
    /**
     * Runs the simulation of students buying crisps.
     * 
     * @param nSteps the amount of steps to run the simulation for.
     */
    public void runSnackBar(int nSteps) {
        for (int step = 1; step <= nSteps; step++) {
            System.out.println("\n\n========== Time Step " + step + " ==========");
            describe();
            students.get(rnd.nextInt(students.size())).snackTime();
        }
    }
}
