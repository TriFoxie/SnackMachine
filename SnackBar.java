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
     * Creates a new snackbar with the specified number of students and packets and the cost.
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
            if (students.size() > 0) {
                students.get(rnd.nextInt(students.size())).snackTime();   
            } else {
                System.out.println("There are no students. Nothing happened.");
            }
        }
    }
    
    /**
     * Help menu to display argument formatting rules.
     */
    public static void help() {
        String helpMsg = "\n========== Help ==========\n" +
            "Usage: java SnackBar <nSteps> <nStudents> <nPackets> <cost>\n" +
            "Ex:    java SnackBar 100 20 50 2\n" +
            "\n" +
            "Arguments:\n" +
            " 0 | nSteps:       The amount of steps to run the simulation for.          Default 10.\n" +
            " 1 | nStudents:    The amount of students to include in the simulation.    Default 10.\n" +
            " 2 | nPackets:     The amount of packets to include in the snack machine.  Default 10.\n" +
            " 3 | cost:         The cost of individual crisp packets.                   Default 2.\n" +
            "If left blank, arguments take their default values.\n" +
            "\n" +
            "'java SnackBar help' to display this message.";
        System.out.println(helpMsg);
    }
    
    private String randomFlavour() {
        return flavours[rnd.nextInt(flavours.length)];
    }
    
    public static void main(String[] args) {
        String nSteps = (1 <= args.length) ? args[0] : "10";
        String nStudents = (2 <= args.length) ? args[1] : "10";
        String nPackets = (3 <= args.length) ? args[2] : "10";
        String cost = (4 <= args.length) ? args[3] : "2";
        
        if (args.length > 4) {
            System.out.println("Too many arguments. Running and discarding extra arguments.");
        }
        if (nSteps.equals("help")) {
            help();
        } else {
            try {
                SnackBar sb = new SnackBar(
                    Integer.parseInt(nStudents), 
                    Integer.parseInt(nPackets),
                    Integer.parseInt(cost)
                );
                sb.runSnackBar(Integer.parseInt(nSteps));
            } catch (NumberFormatException e) {
                System.out.println("Error in argument formatting, displaying help...");
                help();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    } 
}