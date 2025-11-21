
public class Student
{
    private static int STUDENT_ID = 0;
    
    private String favouriteFlavour;
    private SnackMachine snackMachine;
    private String idNumber;
    private Pocket pocket;
    private PackOfCrisps packet;
    
    public Student(String flavour, SnackMachine snackMachine) {
        STUDENT_ID += 1;
        favouriteFlavour = flavour;
        idNumber = "student" + STUDENT_ID;
        pocket = new Pocket(20);
        packet = null;
    }
    
    private void buyCrisps() {
        if (snackMachine.countPacks(favouriteFlavour) == 0) {
            System.out.println("The machine has run out of " + idNumber + "'s favourite, " + favouriteFlavour + " crisps.");
        }
        
    }
}