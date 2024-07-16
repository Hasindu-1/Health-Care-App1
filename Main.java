import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void adminMenue(){



        boolean runAdminMenue=true;




        while(runAdminMenue) {
            try {

                Scanner input = new Scanner(System.in);//taking as new object
                System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability and press 3 to Exit.");

                int userobjective = input.nextInt();//checking new user object

                if (userobjective == 1) {
                    Controller.addDoctor();




                } else if (userobjective == 2) {
                    Controller.addAvailabilityDoc();


                } else if (userobjective == 3) {
                    System.out.println("Exit");
                    runAdminMenue = false;

                } else {
                    System.out.println("Invalid ");
                }
            }catch (Exception e){
                System.out.println("Invalid Input Type :");

            }
        }
    }

    public static void patientMenue(){

        boolean runPatientMenue=true;
        while(runPatientMenue) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Press 1 to view doctor,Press 2 to book  an appointment ,press 3 to view a selected doctor's bookings,press 4 to register patient and press 5 to exit ");

                int userobjective2 = input.nextInt();

                if (userobjective2 == 1) {
                    Controller.viewDoc();


                } else if (userobjective2 == 2) {
                    Controller.makeAppointment();



                } else if (userobjective2 == 3) {
                    Controller.selectingdocbooking();


                } else if (userobjective2 == 4) {
                    Controller.addPatient();



                } else if (userobjective2 == 5) {
                    System.out.println("Exit");
                    runPatientMenue = false;


                } else {
                    System.out.println("Invalid ");
                }
            }catch (Exception e){
                System.out.println(e +"Invalid Input Type :");
            }
        }
    }


    public static  void run(){
        boolean mainMenue=true;

        while(mainMenue){
            try {

                Scanner input = new Scanner(System.in);
                System.out.println("If you are a hospital administrator please press 1\n" +
                        "If you are a patient please press 2\n" +
                        "Press 3 to exit");
                int userType = input.nextInt();


                if (userType == 1) {
                    adminMenue();

                } else if (userType == 2) {
                    patientMenue();
                } else if (userType == 3) {
                    System.out.println("Exit ");
                    mainMenue = false;

                } else {
                    System.out.println("Invalid Input");
                }
            }catch (Exception e){
                System.out.println("invalid input type :");

            }

        }


    }




    public static void main(String[] args) {
        Doctor one = new Doctor(223,"Hasindu","2009","nuro","07333");
        Patient two = new Patient("Jama","1111","00000000","T-12");
        Controller.allDoctors.add(one);
        Controller.allPatient.add(two);

        run();








    }
}
