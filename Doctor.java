import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Doctor extends  Person {
    private int docId;
    private String name;

    private String birthday;

    private   String specialization;

    private ArrayList<Date> availability;
    private String contactNum;

    private HashMap<Date,ArrayList<Appointment>> allAppoinments= new HashMap<>();

    public static void viewSelectedDoc( Doctor selectedDoc,int iddoc){
        for (Map.Entry<Date,ArrayList<Appointment>> appointment : selectedDoc.getAllAppoinments().entrySet()){
            if(selectedDoc.docId == iddoc ){
                System.out.println(selectedDoc.allAppoinments);


            }else {
                System.out.println("No appointments ");
            }

        }





    }


    public int getDocId() {
        return docId;
    }



    public String getBirthday() {
        return birthday;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Date> getAvailability() {
        return availability;
    }

    public HashMap<Date, ArrayList<Appointment>> getAllAppoinments() {
        return allAppoinments;
    }




    public Doctor(int docId, String name, String birthday, String specialization,String contactNum) {
        super(name, contactNum);
        this.docId = docId;
        this.birthday = birthday;
        this.specialization = specialization;
        this.availability=new ArrayList<>();
    }

    public boolean isPhysician(){
        return specialization.endsWith("Physician");
    }

    public void setAvailability(Date availabileDay){
        this.availability.add(availabileDay);

    }

    public void setAppoinments(Appointment appointment,Date date){
        ArrayList<Appointment>currentAppointments=this.allAppoinments.get(date);
        if(currentAppointments == null){
            //if that day no appointments then create a new array list and store it in hash map;
            ArrayList tempArraylist=new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppoinments.put(date,tempArraylist);

        }else {
            //if there is some data then add it to array list and store in hash map.
            currentAppointments.add(appointment);
            this.allAppoinments.put(date,currentAppointments);
        }


    }
    public void viewBookings(Date date) {
        if (allAppoinments.containsKey(date)) {
            ArrayList<Appointment> appointments = allAppoinments.get(date);
            if (appointments.isEmpty()) {
                System.out.println("No bookings for this date.");
            } else {
                for (Appointment appointment : appointments) {
                    System.out.println(appointment);
                }
            }
        } else {
            System.out.println("No bookings for this date.");
        }
    }

}
