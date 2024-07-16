import java.util.*;

public class Controller {
    public static ArrayList<Doctor> allDoctors = new ArrayList<>();

    public static ArrayList<Patient> allPatient= new ArrayList<>();

    public static void addDoctor(){
        boolean adddoc=true;
        while (adddoc){
            try{
                Scanner in= new Scanner(System.in);
                System.out.println("Enter your Name: ");
                String name =in.nextLine();

                System.out.println("Enter your birthday: ");
                String birthday=in.nextLine();

                System.out.println("Enter the specialization: ");
                String specialization=in.nextLine();

                System.out.println("Enter your contact number: ");
                String contactNumber=in.nextLine();

                //import random number to doc ID.
                Random ran = new Random();
                int docId = ran.nextInt();
                System.out.println(docId+" is the docId");

                Doctor tempdoctor= new Doctor(docId,name,birthday,specialization,contactNumber);

                allDoctors.add(tempdoctor);
                System.out.println("Doctor added Successfully:");
                adddoc=false;
            }catch (Exception e){
                System.out.println(e +"Invalid ");
                adddoc=true;
            }



        }

    }

    public static void viewDoc(){
        for (Doctor i : allDoctors){
            System.out.println(i.getName() +" has a specialization of " + i.getSpecialization()+" has a Id of "+i.getDocId()+" and has a availability of"+i.getAvailability().toString());
        }

        System.out.println("Doctor Viewed: ");
    }

    public static void addAvailabilityDoc(){
        boolean available = true;
        while(available) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the doctor Id you want ass availability: ");
            int inputdocid = input.nextInt();

            //checking from doc arraylist to check num is true:
            Doctor selectedDoc = null;

            for (Doctor i : allDoctors) {
                if (i.getDocId() == inputdocid) {
                    selectedDoc = i;
                }
            }
            System.out.println(selectedDoc + " array stored one");//passe delete karanne
            System.out.println(inputdocid + " doc id user input");//same above

            if (selectedDoc == null) {
                System.out.println("No Doc Found :");
                continue;
            } else {
                System.out.println("Enter the Day you want to Add Availability: ");
                int day = input.nextInt();
                System.out.println("Enter the Month you want to Add Availability: ");
                int month = input.nextInt();
                System.out.println("Enter the year you want to Add Availability: ");
                int year = input.nextInt();


                Date bookingDate = new Date(year, month , day);
                selectedDoc.setAvailability(bookingDate);

                System.out.println("Add doctor available date");
                available=false;
            }
        }


    }

    public static  void  addPatient(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Name :");
        String name = input.next();
        System.out.println("Enter your ID :");
        String iD = input.next();
        System.out.println("Enter your ContactNum :");
        String contactNum = input.next();

        Patient patient=new Patient(name,"",contactNum,iD);

        allPatient.add(patient);
        System.out.println(allPatient.toString());
        System.out.println("Patient added :");

    }

    public static void makeAppointment(){
        boolean make=true;
        while(make){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter Doctor's Id you want to make an appointment: ");
                int docId= input.nextInt();
                System.out.println("Enter your patient's Id: ");
                String patientId=input.next();


                System.out.println("Enter the Day you want to Appointment: ");
                String day = input.next();
                System.out.println("Enter the Month you want to Add Appointment: ");
                String month = input.next();
                System.out.println("Enter the year you want to Add Appointment: ");
                String year = input.next();

                //get patient and doctor
                Patient selectedPatient = getPatientById(patientId);

                Doctor selectedDoc = getDoctorById(docId);



                if(selectedDoc == null || selectedPatient == null){
                    System.out.println("Invalid Doc Patient ID ");
                    return;


                }
                Date appointentDate = new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));


                System.out.println("Press 1 for General Appointment, 2 for Referral Appointment:");
                int appointmentType = input.nextInt();




                //check the availability
                boolean isAvailable =  checkAvailability(selectedDoc,appointentDate);
                if(isAvailable){
                    String appTime=getTimeForBookings(selectedDoc,appointentDate);
                    if(appTime != null){

                        if(appointmentType == 1){

                            //upcasting
                            Appointment gAppoinment = new GenralAppointments(selectedDoc,selectedPatient,appointentDate,"");
                            //method cll to store in hash map
                            selectedDoc.setAppoinments(gAppoinment,appointentDate);
                            System.out.println(selectedDoc.getAllAppoinments().toString());
                            System.out.println("General appointment booked successfully!");

                        } else if (appointmentType == 2) {
                            System.out.println("Enter Referral  note :");
                            String note2 = input.next();
                            RefferalAppointments.setReferralDoctorNotes(note2);

                            System.out.println("Enter referral docID");
                            int referralDoctorId = input.nextInt();
                            Doctor referralDoctor= findDoctorById(referralDoctorId);
                            if(referralDoctor == null){
                                System.out.println("Not matching Doc Referral number");

                            }else {
                                //upcasting
                                Appointment rAppointment=new RefferalAppointments(selectedDoc,selectedPatient,appointentDate,"",referralDoctor,note2);
                                selectedDoc.setAppoinments(rAppointment,appointentDate);

                                System.out.println(selectedDoc.getAllAppoinments().toString());

                                System.out.println("Referral appointment booked successfully!");
                            }


                        }else {
                            System.out.println("not matching :");
                        }


                    }else {
                        System.out.println("All the slots are filled:");
                    }


                }else {
                    System.out.println("Doctor is not Available on selected date");

                }
                make=false;

            }catch (Exception e){
                System.out.println(e+"Invalid ");
                make=true;
            }



        }

    }






    public static Doctor findDoctorById(int id ){
        for(Doctor i : allDoctors){
            if(i.getDocId()== id){
                return i;

            }
        }
        return null;

    }
    public static Patient getPatientById(String id){
        for(Patient i : allPatient){
            if(i.getPatientId().equals(id)){
                return  i;
            }

        }
        System.out.println("No Patient Found :");
        return null;

    }
    public static  Doctor getDoctorById(int id){
        for(Doctor i : allDoctors){
            if(i.getDocId() == id){
                return  i;
            }

        }
        System.out.println("No Doctor Found :");
        return null;

    }

    public static boolean checkAvailability(Doctor selectedDoc, Date dateOfBooking){
        for(Date date : selectedDoc.getAvailability()){
            if(date.equals(dateOfBooking)){
                return  true;

            }


        }
        return  false;



    }
    public static void selectingdocbooking(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Doctor's Id you want to make an appointment: ");
        int docId= input.nextInt();
        Doctor selectedDoc = getDoctorById(docId);


        assert selectedDoc != null;
        Doctor.viewSelectedDoc(selectedDoc,docId);
    }


    public static String getTimeForBookings(Doctor selectedDoc ,Date dateOfBooking){
        for(Map.Entry<Date,ArrayList<Appointment>> appointment: selectedDoc.getAllAppoinments().entrySet()){
            if(appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size();
                if(numberOfSlots > 4){
                    return  null;

                }
                System.out.println("We can make a Booking");
                int  time = 17+appointment.getValue().size();
                String strTime = time + ":00";
                return strTime;

            }
        }
        return "17:00";


    }





}
