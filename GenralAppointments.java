import java.util.Date;

public class GenralAppointments extends Appointment {
    private String patientNotes;

    public GenralAppointments(Doctor doctor, Patient patient, Date date, String time) {
        super(doctor, patient, date, time);
        this.patientNotes=patientNotes;
    }
    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }
}
