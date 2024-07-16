import java.util.Arrays;
import java.util.Date;

public class RefferalAppointments extends  Appointment{
    private  Doctor reffralDoctor;
    private String notes;

    public RefferalAppointments(Doctor doctor, Patient patient, Date date, String time,Doctor reffralDoctor,String notes) {
        super(doctor, patient, date, time);
        this.reffralDoctor=reffralDoctor;
        this.notes=notes;
    }
    public  static void setReferralDoctorNotes(String docNotes){
        String notes = docNotes;



    }
    public  static void setReferralDoctorNotes(String[] notesArray){
        for(String notes: notesArray){
            notes=notes+ Arrays.toString(notesArray);
        }




    }



    public Doctor getReffralDoctor() {
        return reffralDoctor;
    }

    public void setReffralDoctor(Doctor reffralDoctor) {
        this.reffralDoctor = reffralDoctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setReferal(String notes) {
        this.notes = notes;
    }





}
