import java.util.Date;

public   abstract   class Appointment {
    private Doctor doctor;

    private Patient patient;

    private Date date;

    private String time;
    public Appointment(Doctor doctor, Patient patient,  Date date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        //this.notes = notes;
        this.date = date;
        this.time = time;
    }

    public Doctor getDoctor(){
        return  doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Patient getPatient(){
        return  patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
